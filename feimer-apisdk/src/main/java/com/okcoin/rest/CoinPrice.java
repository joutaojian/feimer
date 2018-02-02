/**
  * Copyright 2018 bejson.com 
  */
package com.okcoin.rest;

/**
 * Auto-generated: 2018-02-01 23:11:53
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CoinPrice {

    private String date;
    private Ticker ticker;
    public void setDate(String date) {
         this.date = date;
     }
     public String getDate() {
         return date;
     }

    public void setTicker(Ticker ticker) {
         this.ticker = ticker;
     }
     public Ticker getTicker() {
         return ticker;
     }

}