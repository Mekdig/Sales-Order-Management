package org.zeetransportations.salesordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class ShippingAddress {

    private String street;
    private String state;
    private Integer zipcode;

}
