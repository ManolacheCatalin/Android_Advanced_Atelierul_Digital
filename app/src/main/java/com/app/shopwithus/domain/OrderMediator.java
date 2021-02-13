package com.app.shopwithus.domain;

import com.app.shopwithus.data.model.Order;
import com.app.shopwithus.data.remote.SendOrder;

public class OrderMediator {

    private SendOrder sendOrder;

    public OrderMediator(SendOrder sendOrder){
        this.sendOrder=sendOrder;
    }
    public void sendOrder(Order order){
     sendOrder.startCall(order);
    }
}
