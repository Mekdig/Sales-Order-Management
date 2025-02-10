package org.zeetransportations.salesordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
@Table(name = "Sales_Table")
@Entity
@Data

public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Embedded
    private Products products;

    private double discount;

    @Embedded
    private ShippingAddress shippingAddress;
    private String notes;

}
