package com.thevaslabs.basicinstrumentation2.service.impl;

import com.thevaslabs.basicinstrumentation2.domain.Inventory;
import com.thevaslabs.basicinstrumentation2.service.InventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public Inventory deductInventory(Inventory inventory) {
        return Inventory.builder()
                .productId(inventory.productId())
                .orderedQuantity(inventory.orderedQuantity())
                .availableQuantity(inventory.availableQuantity())
                .dateOfTrnx(inventory.dateOfTrnx())
                .build();
    }
}
