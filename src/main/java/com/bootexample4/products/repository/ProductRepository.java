package com.bootexample4.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootexample4.products.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
