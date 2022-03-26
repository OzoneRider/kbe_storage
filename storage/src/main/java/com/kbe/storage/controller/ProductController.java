package com.kbe.storage.controller;

import com.kbe.storage.models.entities.Product;
import com.kbe.storage.services.CsvImportService;
import com.kbe.storage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/csv/")
public class ProductController {

    @Autowired
    CsvImportService csvImportService;
    @Autowired
    ProductService productService;

    @GetMapping("products/import")
    public ResponseEntity<List<Product>> importProducts(){
        return csvImportService.readCsvFromFolder();
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
    }
}
