package org.zeetransportations.salesordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeetransportations.salesordermanagement.entity.Sales;
import org.zeetransportations.salesordermanagement.service.SalesService;

@RestController
@RequestMapping("/orders")
public class SalesController {

    private final SalesService salesService;

    // Constructor-based dependency injection (No need for @Autowired)
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    // Create Order (Fixed Status Code)
    @PostMapping("/create")
    public ResponseEntity<Sales> postOrderInfo(@RequestBody Sales postOrderInfo) {
        Sales sales1 = salesService.postOrderInfo(postOrderInfo);
        return new ResponseEntity<>(sales1, HttpStatus.CREATED); // 201 Created
    }

    // Get Order by ID (Fixed - Removed @RequestBody)
    @GetMapping("/get/{orderId}")
    public ResponseEntity<Sales> getOrderInfo(@PathVariable Long orderId) {
        Sales sales1 = salesService.getOrderInfo(orderId);
        return new ResponseEntity<>(sales1, HttpStatus.OK);
    }

    // Update Order (PUT)
    @PutMapping("/update/{orderId}")
    public ResponseEntity<Sales> putOrderInfo(@PathVariable Long orderId, @RequestBody Sales putOrderInfo) {
        Sales sales1 = salesService.putOrderInfo(orderId, putOrderInfo);
        return new ResponseEntity<>(sales1, HttpStatus.OK);
    }
}