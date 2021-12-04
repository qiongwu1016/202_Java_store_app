package com.store.app;
import java.util.Vector;

import java.util.List;

public class Order {
    private Float totalPrice;
    private List<Request> requests;

    public Order(){
        requests = new Vector<Request>();
    }

    public Float getTotalPrice() {
        return this.totalPrice;
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean process() {
        Handler handler1 = new QuantityHandler(this);
        Handler handler2 = new CategoryCapHandler(this);
        Handler handler3 = new ValidOrderHandler(this);
        Handler handler4 = new CardHandler(this);
        handler1.linkWith(handler2);
        handler2.linkWith(handler3);
        handler3.linkWith(handler4);
        return handler1.validate();

    }


}
