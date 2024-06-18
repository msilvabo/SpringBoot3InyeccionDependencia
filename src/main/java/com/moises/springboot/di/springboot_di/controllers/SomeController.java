package com.moises.springboot.di.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.moises.springboot.di.springboot_di.models.Product;
import com.moises.springboot.di.springboot_di.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired       
    private ProductService services;
  
    // public SomeController(ProductService services) {
    //     this.services = services;
    // }

    @GetMapping("")
    public List<Product> list(){
        return services.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return services.findbyId(id);
    }    
}
