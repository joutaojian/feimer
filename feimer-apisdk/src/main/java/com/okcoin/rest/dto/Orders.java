/**
  * Copyright 2018 bejson.com 
  */
package com.okcoin.rest.dto;

/**
 * Auto-generated: 2018-02-01 23:34:58
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Orders {

    private double amount;
    private double avg_price;
    private long create_date;
    private double deal_amount;
    private long order_id;
    private long orders_id;
    private double price;
    private int status;
    private String symbol;
    private String type;
    public void setAmount(double amount) {
         this.amount = amount;
     }
     public double getAmount() {
         return amount;
     }

    public void setAvg_price(double avg_price) {
         this.avg_price = avg_price;
     }
     public double getAvg_price() {
         return avg_price;
     }

    public void setCreate_date(long create_date) {
         this.create_date = create_date;
     }
     public long getCreate_date() {
         return create_date;
     }

    public void setDeal_amount(double deal_amount) {
         this.deal_amount = deal_amount;
     }
     public double getDeal_amount() {
         return deal_amount;
     }

    public void setOrder_id(long order_id) {
         this.order_id = order_id;
     }
     public long getOrder_id() {
         return order_id;
     }

    public void setOrders_id(long orders_id) {
         this.orders_id = orders_id;
     }
     public long getOrders_id() {
         return orders_id;
     }

    public void setPrice(double price) {
         this.price = price;
     }
     public double getPrice() {
         return price;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setSymbol(String symbol) {
         this.symbol = symbol;
     }
     public String getSymbol() {
         return symbol;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

}