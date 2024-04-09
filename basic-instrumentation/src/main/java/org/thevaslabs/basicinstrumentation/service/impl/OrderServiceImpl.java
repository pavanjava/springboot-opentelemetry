package org.thevaslabs.basicinstrumentation.service.impl;

import org.springframework.stereotype.Service;
import org.thevaslabs.basicinstrumentation.domain.Order;
import org.thevaslabs.basicinstrumentation.domain.Product;
import org.thevaslabs.basicinstrumentation.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    List<Order> orders;

    public OrderServiceImpl() {
        orders = List.of(
                Order.builder()
                        .id(12345676)
                        .customerId(12345)
                        .products(List.of(Product.builder()
                                .id(1234)
                                .name("Test Product")
                                .unitPrice(3453.34f)
                                .categoryId(12)
                                .description("test description of the product")
                                .orderedQuantity(1)
                                .build()))
                        .orderAmount(3453.34).build()
        );
    }

    @Override
    public Order getOrderById(long orderId) {
        return orders.stream().filter(order -> order.id() == orderId).findFirst().orElse(null);
    }
}
