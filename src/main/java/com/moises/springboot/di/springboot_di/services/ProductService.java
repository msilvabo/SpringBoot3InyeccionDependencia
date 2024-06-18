package com.moises.springboot.di.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.moises.springboot.di.springboot_di.models.Product;
import com.moises.springboot.di.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> finAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            // p.setPrice(p.getPrice() * 1.25d);
            Product newProd = new Product(p.getId(), p.getName(), priceImp);
            return newProd; 
        }).collect(Collectors.toList());
    }

    public Product finbyId (Long id){
        return repository.findbyId(id);
    }
}
