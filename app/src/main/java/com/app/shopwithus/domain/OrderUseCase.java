package com.app.shopwithus.domain;

import com.app.shopwithus.data.model.Order;

public class OrderUseCase {

    private final OrderMediator mediator;

    public OrderUseCase(OrderMediator mediator){
        this.mediator = mediator;
    }
    public void sendOrder(Order order){
        mediator.sendOrder(order);
    }
}
