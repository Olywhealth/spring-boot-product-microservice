package com.olaoye.inventoryservice.service;

import org.springframework.http.ResponseEntity;

public interface InventoryService {
    Boolean isInStock(String skuCode);
}
