package com.ecommerce.product.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String titre;

    private String description;

    private String image;

    private Double prix;




}
