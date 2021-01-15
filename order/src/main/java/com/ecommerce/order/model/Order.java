package com.ecommerce.order.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private Integer productId;

    private Date date;

    private Integer quantity;

}
