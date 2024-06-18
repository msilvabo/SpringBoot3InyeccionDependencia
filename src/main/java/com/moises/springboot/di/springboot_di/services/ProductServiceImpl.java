package com.moises.springboot.di.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.moises.springboot.di.springboot_di.models.Product;
import com.moises.springboot.di.springboot_di.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            // p.setPrice(p.getPrice() * 1.25d);
            Product newProd = (Product) p.clone(); 
            newProd.setPrice(priceTax);
            return newProd; 
        }).collect(Collectors.toList());
    }

    @Override
    public Product findbyId (Long id){
        return repository.findbyId(id);
    }

    
}
