package com.thevaslabs.inventoryservice.service.impl;

import com.thevaslabs.inventoryservice.domain.Inventory;
import com.thevaslabs.inventoryservice.service.InventoryService;
import io.micrometer.tracing.annotation.NewSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    @Override
    @NewSpan(value = "inventory-service-deductInventory-span")
    public Inventory deductInventory(Inventory inventory) {
        log.info("Deducting inventory {}", inventory.toString());
        return Inventory.builder()
                .productId(inventory.productId())
                .orderedQuantity(inventory.orderedQuantity())
                .availableQuantity(inventory.availableQuantity())
                .dateOfTrnx(inventory.dateOfTrnx())
                .build();
    }
}
