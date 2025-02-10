package org.zeetransportations.salesordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeetransportations.salesordermanagement.entity.Sales;
import org.zeetransportations.salesordermanagement.respository.SalesRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public Sales getOrderInfo(int orderId, Sales sales){
        Optional<Sales>salesOptional = salesRepository.findById(orderId);
        if(salesOptional.isEmpty()){
            throw new NoSuchElementException();
        }

        Sales sales1 = salesOptional.get();
        sales1.setDiscount(sales.getDiscount());
        sales1.setNotes(sales.getNotes());
        sales1.setProducts(sales.getProducts());
        sales1.setShippingAddress(sales.getShippingAddress());

        Sales saveSalesInfo = salesRepository.save(sales1);
        return saveSalesInfo;
    }

    public Sales postOrderInfo(Sales sales){
        return salesRepository.save(sales);
    }

    public Sales putOrderInfo(int orderId, Sales sales){
        Optional<Sales>salesOptional1 = salesRepository.findById(orderId);
        if(salesOptional1.isEmpty()){
            throw new NoSuchElementException();
        }

        Sales sales1 = salesOptional1.get();
        sales1.setDiscount(sales.getDiscount());
        sales1.setNotes(sales.getNotes());
        sales1.setProducts(sales.getProducts());
        sales1.setShippingAddress(sales.getShippingAddress());

        Sales saveSalesInfo = salesRepository.save(sales1);
        return saveSalesInfo;
    }

}

