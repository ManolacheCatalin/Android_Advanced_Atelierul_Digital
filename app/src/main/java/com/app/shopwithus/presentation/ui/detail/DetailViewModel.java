package com.app.shopwithus.presentation.ui.detail;

import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.app.shopwithus.data.model.Order;
import com.app.shopwithus.data.model.Product;
import com.app.shopwithus.domain.OrderUseCase;
import com.app.shopwithus.presentation.ui.notification.NotificationFactory;

public class DetailViewModel extends ViewModel implements SendOrderClick {

    private Product product;
    private final OrderUseCase orderUseCase;
    private Integer q = 0;

    public DetailViewModel(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    public Product getProduct() {
        product = ProductHelp.getInstance().getProduct();
        return product;
    }


    public void setQ(Integer q) {
        this.q = q;
    }

    @Override
    public void confirm(Product product, View view) {
        Double total = (q * product.getProductPrice());
        Order orderToConfirm = new Order(total, q, product.getProductPrice(), product.getProductId());
        orderUseCase.sendOrder(orderToConfirm);
        NotificationFactory.createNotification(view.getContext());
    }
}
