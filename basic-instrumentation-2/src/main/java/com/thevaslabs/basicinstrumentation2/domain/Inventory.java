package com.thevaslabs.basicinstrumentation2.domain;

import lombok.Builder;

@Builder
public record Inventory(int productId, int orderedQuantity, int availableQuantity, String dateOfTrnx) {
}
