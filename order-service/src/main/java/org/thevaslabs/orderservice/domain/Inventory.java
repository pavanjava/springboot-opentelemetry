package org.thevaslabs.orderservice.domain;

import lombok.Builder;

@Builder
public record Inventory(int productId, int orderedQuantity, int availableQuantity, String dateOfTrnx) {
}
