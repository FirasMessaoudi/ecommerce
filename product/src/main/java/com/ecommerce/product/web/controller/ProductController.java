package com.ecommerce.product.web.controller;


import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.model.Product;
import com.mproduits.web.exceptions.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductDao productDao;

    Logger log = LoggerFactory.getLogger(this.getClass());


    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/Produits")
    public List<Product> findAll(){

        List<Product> products = productDao.findAll();

        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

        log.info("Récupération de la liste des produits");

        return products;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/Produits/{id}")
    public Optional<Product> recupererUnProduit(@PathVariable int id) {

        Optional<Product> product = productDao.findById(id);

        if(!product.isPresent())  throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

        return product;
    }

}

