package com.moises.springboot.di.springboot_di.repositories;

import java.util.List;

import com.moises.springboot.di.springboot_di.models.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findbyId(Long id);
}
