package com.ecommerce.client.controller;


import com.ecommerce.client.dto.OrderDTO;
import com.ecommerce.client.dto.ProductDTO;
import com.ecommerce.client.proxies.MicroserviceOrderProxy;
import com.ecommerce.client.proxies.MicroserviceProductsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


@RestController
@CrossOrigin("*")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private MicroserviceProductsProxy ProductsProxy;

    @Autowired
    private MicroserviceOrderProxy OrdersProxy;

    @GetMapping("/products")
    public List<ProductDTO> findAll(){

        List<ProductDTO> Products =  ProductsProxy.findAll();
        return Products;

    }


    @GetMapping("/findById/{id}")
    public ProductDTO findById(@PathVariable int id){

        ProductDTO produit = ProductsProxy.findById(id);

        return produit;
    }

    @PostMapping(value = "/Order-product")
    public OrderDTO addOrder(@RequestBody ProductDTO productDTO){


        OrderDTO order = new OrderDTO();

        order.setProductId(productDTO.getId());
        order.setQuantity(1);
        order.setDate(new Date());

        OrderDTO OrderAdded = OrdersProxy.addOrder(order);


        return OrderAdded;
    }


}
