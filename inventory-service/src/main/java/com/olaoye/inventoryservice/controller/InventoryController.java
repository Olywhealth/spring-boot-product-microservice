package com.olaoye.inventoryservice.controller;

import com.olaoye.inventoryservice.dto.InventoryResponse;
import com.olaoye.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;
    //http://localhost:8082/api/inventory/iphone-13,iphone13-red perhaps you're using @PathVariable
    //http://localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone13-red when using @RequestParam here I prefer requestParam
    @GetMapping()
    public ResponseEntity<List<InventoryResponse>> isInStock(@RequestParam List<String> skuCode) {
        List<InventoryResponse> check = inventoryService.isInStock(skuCode);
        return new ResponseEntity<>(check, HttpStatus.OK);
    }
}
