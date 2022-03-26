package com.kbe.storage.services;

import com.kbe.storage.exceptions.DataNotFoundException;
import com.kbe.storage.exceptions.NoProductDataException;
import com.kbe.storage.models.entities.Product;
import com.kbe.storage.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws NoProductDataException{
        List<Product> products = productRepository.findAll();

        if(products.isEmpty())
            throw new NoProductDataException();
        return products;
    }

    public Product findProductById(int id){
        return productRepository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
