package org.zeetransportations.salesordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeetransportations.salesordermanagement.entity.Sales;
import org.zeetransportations.salesordermanagement.respository.SalesRepository;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    // Get Order by ID (Fixed)
    public Sales getOrderInfo(Long orderId) {
        return salesRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found with ID: " + orderId));
    }

    // Create New Order (Fixed)
    public Sales postOrderInfo(Sales sales) {
        // Ensure products are linked to sales
        if (sales.getProducts() != null) {
            sales.getProducts().forEach(product -> product.setSales(sales));
        }

        // Calculate Total Amount
        BigDecimal totalAmount = calculateTotalAmount(sales);
        sales.setTotalAmount(totalAmount);

        // Set default status
        sales.setStatus("Pending");

        return salesRepository.save(sales);
    }

    // Update Existing Order (Fixed)
    public Sales putOrderInfo(Long orderId, Sales updatedSales) {
        Sales existingOrder = salesRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found with ID: " + orderId));

        // Update fields
        existingOrder.setDiscount(updatedSales.getDiscount());
        existingOrder.setNotes(updatedSales.getNotes());
        existingOrder.setShippingAddress(updatedSales.getShippingAddress());

        // Ensure products are linked to the existing order
        if (updatedSales.getProducts() != null) {
            updatedSales.getProducts().forEach(product -> product.setSales(existingOrder));
        }
        existingOrder.setProducts(updatedSales.getProducts());

        // Recalculate Total Amount
        BigDecimal updatedTotalAmount = calculateTotalAmount(existingOrder);
        existingOrder.setTotalAmount(updatedTotalAmount);

        return salesRepository.save(existingOrder);
    }

    // Helper Method: Calculate Total Amount
    private BigDecimal calculateTotalAmount(Sales sales) {
        if (sales.getProducts() == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalAmount = sales.getProducts().stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .subtract(sales.getDiscount() != null ? sales.getDiscount() : BigDecimal.ZERO); // Fix: Avoid NullPointerException

        return totalAmount;
    }


}