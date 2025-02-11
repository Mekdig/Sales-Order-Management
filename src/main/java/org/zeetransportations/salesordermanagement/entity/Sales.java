package org.zeetransportations.salesordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "Sales_Table")
@Entity
@Data

public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId; // Changed from customerId to orderId

    private String customerId; // This references the customer, not the primary key


    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Products> products; // Removed @JoinColumn, since it's defined in Products

    private BigDecimal totalAmount;
    private String status;
    private BigDecimal discount;

    @Embedded
    private ShippingAddress shippingAddress;

    private String notes;
}