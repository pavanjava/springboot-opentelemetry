package org.thevaslabs.basicinstrumentation.domain;

import lombok.Builder;

import java.util.List;

@Builder
public record Order(long id, long customerId, double orderAmount, List<Product> products) {
}
