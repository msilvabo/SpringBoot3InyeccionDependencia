package com.moises.springboot.di.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moises.springboot.di.springboot_di.models.Product;
import com.moises.springboot.di.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    // @Autowired
    // @Qualifier("productFoo")
    private ProductRepository repository;
    @Autowired   
    private Environment environment;

    @Value("${config.price.tax}")
    private double tax;
    
    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    // @Autowired   
    // public void setRepository(ProductRepository repository) {
    //     this.repository = repository;
    // }   

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            System.out.println(tax);
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
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
