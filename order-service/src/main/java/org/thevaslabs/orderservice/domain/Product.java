package org.thevaslabs.orderservice.domain;

import lombok.Builder;

@Builder
public record Product(int id, String name, int categoryId, String description, float unitPrice, int orderedQuantity) {
}
