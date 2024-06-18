package com.moises.springboot.di.springboot_di.services;

import java.util.List;

import com.moises.springboot.di.springboot_di.models.Product;

public interface ProductService  {
    List<Product> findAll();
    Product findbyId(Long id);
}
