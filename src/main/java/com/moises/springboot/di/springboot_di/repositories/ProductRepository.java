package com.moises.springboot.di.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.moises.springboot.di.springboot_di.models.Product;

public class ProductRepository {
    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Cpu Intel i9", 100),
            new Product(2L, "Memoria ddr4", 200),
            new Product(3L, "Teclado Raizer Mini", 20.5),
            new Product(3L, "Tarjeta Madre", 120.5)
            );
    }

    public List<Product> findAll() {
        return this.data;
    }

    public Product findbyId(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
