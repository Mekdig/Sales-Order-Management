package org.zeetransportations.salesordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeetransportations.salesordermanagement.entity.Sales;
import org.zeetransportations.salesordermanagement.service.SalesService;

@RestController
@RequestMapping ("/orders")

public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("get/{orderId}")
    public ResponseEntity<?>getOrderInfo(@PathVariable int orderId, @RequestBody Sales sales){
        Sales sales1 = salesService.getOrderInfo(orderId, sales);

        return new ResponseEntity<>(sales1, HttpStatus.OK);
    }

    @PostMapping ("/create")
    public ResponseEntity<?> postOrderInfo(@RequestBody Sales sales){
        Sales sales1 = salesService.postOrderInfo(sales);
        return new ResponseEntity<>(sales1, HttpStatus.OK);

    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<?>putOrderInfo(@PathVariable int orderId, @RequestBody Sales sales){
        Sales sales1 = salesService.putOrderInfo(orderId, sales);

        return new ResponseEntity<>(sales1, HttpStatus.OK);
    }



}
