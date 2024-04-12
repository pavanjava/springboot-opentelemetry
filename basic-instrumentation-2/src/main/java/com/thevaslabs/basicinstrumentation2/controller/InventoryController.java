package com.thevaslabs.basicinstrumentation2.controller;

import com.thevaslabs.basicinstrumentation2.domain.Inventory;
import com.thevaslabs.basicinstrumentation2.service.InventoryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping(value = "/deduct-inventory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventory> deductInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.deductInventory(inventory));
    }
}
