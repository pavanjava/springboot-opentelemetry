package org.thevaslabs.orderservice.service.impl;

import io.micrometer.tracing.annotation.NewSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thevaslabs.orderservice.domain.Inventory;
import org.thevaslabs.orderservice.domain.Order;
import org.thevaslabs.orderservice.domain.Product;
import org.thevaslabs.orderservice.service.OrderService;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    List<Order> orders;
    private final RestTemplate restTemplate;
    @Value("${inventory-service.endpoint}")
    private String inventoryServiceEndpoint;
    @Value("${email-service.endpoint}")
    private String emailServiceEndpoint;

    public OrderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        String orderId = UUID.randomUUID().toString();
        orders = List.of(
                Order.builder()
                        .id(orderId)
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
    @NewSpan(value = "order-service-getOrderById-span")
    public Order getOrderById(String orderId) {
        Order orderResponse = orders.stream().filter(order -> order.id() == orderId).findFirst().orElse(null);
        log.info(orderResponse.toString());
        return orderResponse;
    }

    @Override
    public Order createOrder(Order order) {
        // TODO: actual database persistence logic
        log.info("order placed successfully");
        Inventory inventory = Inventory.builder()
                .productId(1)
                .dateOfTrnx("13-Apr-2024")
                .orderedQuantity(10)
                .availableQuantity(100)
                .build();
        Inventory inventoryResponse = restTemplate.postForObject(inventoryServiceEndpoint, inventory, Inventory.class);
        log.info(inventoryResponse.toString());
        boolean notificationStatus = restTemplate.postForObject(emailServiceEndpoint, order, Boolean.class);
        log.info(String.format("Notification status: %s", notificationStatus));
        return order;
    }
}
