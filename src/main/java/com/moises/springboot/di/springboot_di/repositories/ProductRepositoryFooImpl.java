package com.moises.springboot.di.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.moises.springboot.di.springboot_di.models.Product;

// @Primary
@Repository
public class ProductRepositoryFooImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Mackintosh", 500.5));
    }

    @Override
    public Product findbyId(Long id) {
        return new Product(id, "Mackintosh", 500.5);
    }

}
