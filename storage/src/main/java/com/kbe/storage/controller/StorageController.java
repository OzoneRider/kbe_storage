package com.kbe.storage.controller;

import com.kbe.storage.services.CsvImportService;
import com.kbe.storage.services.DeliveryInformationService;
import com.kbe.storage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StorageController {

    @Autowired
    CsvImportService csvImportService;
    @Autowired
    DeliveryInformationService deliveryInformationService;
    @Autowired
    ProductService productService;
}
