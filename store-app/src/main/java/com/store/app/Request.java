package com.store.app;

public class Request {
    private String itemName;
    private Integer quantity;
    private String cardNumber;

    public Request(String item, Integer quantity, String cardNumber){
        this.itemName = item;
        this.quantity = quantity;
        this.cardNumber = cardNumber;

    }
    
    public String getItemName() {
        return this.itemName;
    }
    public Integer getQuantity() {
        return this.quantity;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String toString() {
        return "Request: item = " + this.itemName +"   request quantity = " + this.quantity + "   card number = " + this.cardNumber;
    }
}
