package com.thevaslabs.inventoryservice.service;

import com.thevaslabs.inventoryservice.domain.Inventory;

public interface InventoryService {

    Inventory deductInventory(Inventory inventory);
}
