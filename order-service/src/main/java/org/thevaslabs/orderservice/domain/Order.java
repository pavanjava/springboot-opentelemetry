package org.thevaslabs.orderservice.domain;

import lombok.Builder;

import java.util.List;

@Builder
public record Order(String id, long customerId, double orderAmount, List<Product> products) {
}
