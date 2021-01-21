package com.ecommerce.client.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private int id;

    private String titre;

    private String description;

    private String image;

    private Double prix;
}
