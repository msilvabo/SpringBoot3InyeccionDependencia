package com.moises.springboot.di.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moises.springboot.di.springboot_di.models.Product;
import com.moises.springboot.di.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;
    
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    // @Autowired   
    // public void setRepository(ProductRepository repository) {
    //     this.repository = repository;
    // }   

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
