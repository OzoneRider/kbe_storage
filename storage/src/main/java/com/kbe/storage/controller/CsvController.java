package com.kbe.storage.controller;

import com.kbe.storage.models.entities.Product;
import com.kbe.storage.services.CsvImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/csv/")
@RequiredArgsConstructor
public class CsvController {


    private final CsvImportService csvImportService;

    @GetMapping("products/import")
    public ResponseEntity<List<Product>> importFromCSV(){
        return csvImportService.readCsvFromFolder("products.csv");
    }
}
