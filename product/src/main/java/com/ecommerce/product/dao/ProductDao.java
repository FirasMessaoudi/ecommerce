package com.ecommerce.product.dao;

import com.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
}
