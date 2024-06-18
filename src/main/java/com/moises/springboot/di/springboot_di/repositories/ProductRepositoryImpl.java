package com.moises.springboot.di.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.moises.springboot.di.springboot_di.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Cpu Intel i9", 100),
            new Product(2L, "Memoria ddr4", 200),
            new Product(3L, "Teclado Raizer Mini", 20.5),
            new Product(4L, "Tarjeta Madre", 120.5)
            );
    }

    @Override    
    public List<Product> findAll() {
        return this.data;
    }

    @Override
    public Product findbyId(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
