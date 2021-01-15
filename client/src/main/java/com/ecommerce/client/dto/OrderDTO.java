package com.ecommerce.client.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    private int id;

    private Integer productId;

    private Date date;

    private Integer quantity;



}
