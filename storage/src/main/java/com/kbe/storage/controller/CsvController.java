package com.kbe.storage.controller;

import com.kbe.storage.models.entities.Product;
import com.kbe.storage.services.CsvImportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/csv/")
public class CsvController {


    private final CsvImportService csvImportService;

    public CsvController(CsvImportService csvImportService){
        this.csvImportService = csvImportService;
    }

    @GetMapping("products/import")
    public ResponseEntity<List<Product>> importFromCSV(){
        return csvImportService.readCsvFromFolder();
    }
}
