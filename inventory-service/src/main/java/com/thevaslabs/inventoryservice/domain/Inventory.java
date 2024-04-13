package com.thevaslabs.inventoryservice.domain;

import lombok.Builder;

@Builder
public record Inventory(int productId, int orderedQuantity, int availableQuantity, String dateOfTrnx) {
}
