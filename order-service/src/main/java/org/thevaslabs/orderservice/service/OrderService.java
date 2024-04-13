package org.thevaslabs.orderservice.service;

import org.thevaslabs.orderservice.domain.Order;

public interface OrderService {
    Order getOrderById(String orderId);
    Order createOrder(Order order);
}
