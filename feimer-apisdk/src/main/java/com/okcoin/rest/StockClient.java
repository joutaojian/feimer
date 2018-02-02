package com.okcoin.rest;

import java.io.IOException;
import java.math.BigDecimal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.okcoin.rest.dto.HistoryPrice;
import org.apache.http.HttpException;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.rest.stock.IStockRestApi;
import com.okcoin.rest.stock.impl.StockRestApi;

/**
 * 现货 REST API 客户端请求
 * @author zhangchi
 *
 */
public class StockClient {
	


	public static void main(String[] args) throws HttpException, IOException{

		long orl_ordersId = 0;

		String api_key = "50edcdbb-99c0-4607-a6e0-dab404bbe866";  //OKCoin申请的apiKey
		String secret_key = "5416A355F2F164A7F51E9DAAF42694BD";
 	    String url_prex = "https://www.okex.com";  //注意：请求URL 国际站https://www.okcoin.com ; 国内站https://www.okcoin.cn
	
	    /**
	     * get请求无需发送身份认证,通常用于获取行情，市场深度等公共信息
	     * 
	    */
	    IStockRestApi stockGet = new StockRestApi(url_prex);
		
	    /**
	     * post请求需发送身份认证，获取用户个人相关信息时，需要指定api_key,与secret_key并与参数进行签名，
	     * 此处对构造方法传入api_key与secret_key,在请求用户相关方法时则无需再传入，
	     * 发送post请求之前，程序会做自动加密，生成签名。
	     * 
	    */
	    IStockRestApi stockPost = new StockRestApi(url_prex, api_key, secret_key);
		
	    //现货行情
	    String result = stockGet.ticker("eos_usdt");
		CoinPrice coinPrice = JSON.parseObject(result, new TypeReference<CoinPrice>() {});
		double newPrice = Double.parseDouble(coinPrice.getTicker().getLast());
		newPrice = Double.parseDouble(new java.text.DecimalFormat("#.0").format(newPrice));

		for(int i = 0;i<5;i++){

//			String check = stockPost.order_history("eos_usdt", "0", "1", "20");
//			HistoryPrice checkHistoryPrice = JSON.parseObject(check, new TypeReference<HistoryPrice>() {});
//			if(checkHistoryPrice.getOrders().size() == 0 || checkHistoryPrice.getOrders() == null){
//				break;
//			}

			System.out.println(new java.text.DecimalFormat("#.00").format(newPrice-0.1*i) );//买
			stockPost.trade("eos_usdt", "buy", new java.text.DecimalFormat("#.00").format(newPrice-0.1*i) , "0.1");
			System.out.println(new java.text.DecimalFormat("#.00").format(newPrice+0.1*(i+1) ));//卖
			stockPost.trade("eos_usdt", "sell", new java.text.DecimalFormat("#.00").format(newPrice+0.1*(i+1) ), "0.1");
		}


		while(true){

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			String history = stockPost.order_history("eos_usdt", "1", "1", "20");
			HistoryPrice historyPrice = JSON.parseObject(history, new TypeReference<HistoryPrice>() {});
			double finishPrice  = historyPrice.getOrders().get(0).getPrice();
			String orderSell = historyPrice.getOrders().get(0).getType();
			long ordersId = historyPrice.getOrders().get(0).getOrder_id();
			finishPrice = Double.parseDouble(new java.text.DecimalFormat("#.0").format(finishPrice));


			if(orl_ordersId!=0 && orl_ordersId!=ordersId){
				if ("sell".equals(orderSell)){
					//买，finishPrice-0.1
					stockPost.trade("eos_usdt", "buy", new java.text.DecimalFormat("#.00").format(finishPrice-0.1) , "0.1");
				}else{
					//卖, finishPrice+0.1
					stockPost.trade("eos_usdt", "sell", new java.text.DecimalFormat("#.00").format(finishPrice+0.1 ), "0.1");
				}
			}

			orl_ordersId = ordersId;

		}




//		String tradeResult = stockPost.trade("btc_usd", "buy", "50", "0.02");
//		System.out.println(tradeResult);
//		JSONObject tradeJSV1 = JSONObject.parseObject(tradeResult);
//		String tradeOrderV1 = tradeJSV1.getString("order_id");
		
	}
}
