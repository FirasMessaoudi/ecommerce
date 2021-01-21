package com.ecommerce.client.proxies;


import com.ecommerce.client.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "zuul-server")

public interface MicroserviceProductsProxy {

    @GetMapping(value = "/microservice-product/products")
    List<ProductDTO> findAll();

    /*
    * Notez ici la notation @PathVariable("id") qui est différente de celle qu'on utlise dans le contrôleur
    **/
    @GetMapping( value = "/microservice-product/products/{id}")
    ProductDTO findById(@PathVariable("id") int id);



}
