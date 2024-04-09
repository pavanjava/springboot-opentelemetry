package org.thevaslabs.basicinstrumentation.service;

import org.thevaslabs.basicinstrumentation.domain.Order;

public interface OrderService {
    Order getOrderById(long orderId);
}
