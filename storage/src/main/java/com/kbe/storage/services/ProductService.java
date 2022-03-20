package com.kbe.storage.services;

import com.kbe.storage.models.entities.Product;
import com.kbe.storage.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(int id){
        return productRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Product with Id"+id+"does not exist"));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
