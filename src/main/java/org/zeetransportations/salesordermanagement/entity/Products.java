package org.zeetransportations.salesordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class Products {
    private Integer productId;
    private double quantity;
    private double price;


}
