package org.zeetransportations.salesordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Table(name="products")
@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    private int quantity; // Changed from double to int
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "sales_id", nullable = false) // Foreign key to Sales table
    private Sales sales;
}