package com.thevaslabs.basicinstrumentation2.service;

import com.thevaslabs.basicinstrumentation2.domain.Inventory;

public interface InventoryService {

    Inventory deductInventory(Inventory inventory);
}
