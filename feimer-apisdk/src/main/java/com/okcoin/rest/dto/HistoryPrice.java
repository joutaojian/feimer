/**
  * Copyright 2018 bejson.com 
  */
package com.okcoin.rest.dto;
import java.util.List;

/**
 * Auto-generated: 2018-02-01 23:34:58
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class HistoryPrice {

    private boolean result;
    private int total;
    private int currency_page;
    private int page_length;
    private List<Orders> orders;
    public void setResult(boolean result) {
         this.result = result;
     }
     public boolean getResult() {
         return result;
     }

    public void setTotal(int total) {
         this.total = total;
     }
     public int getTotal() {
         return total;
     }

    public void setCurrency_page(int currency_page) {
         this.currency_page = currency_page;
     }
     public int getCurrency_page() {
         return currency_page;
     }

    public void setPage_length(int page_length) {
         this.page_length = page_length;
     }
     public int getPage_length() {
         return page_length;
     }

    public void setOrders(List<Orders> orders) {
         this.orders = orders;
     }
     public List<Orders> getOrders() {
         return orders;
     }

}