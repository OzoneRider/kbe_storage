package com.kbe.storage.controller;

import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.services.CsvImportService;
import com.kbe.storage.services.DeliveryInformationService;
import com.kbe.storage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class StorageController {

    @Autowired
    CsvImportService csvImportService;
    @Autowired
    DeliveryInformationService deliveryInformationService;
    @Autowired
    ProductService productService;

    @GetMapping("DeliveryInformation/{id}")
    public DeliveryInformation getDeliveryInformation(@PathVariable("id") Integer id){
        return deliveryInformationService.findDeliveryInformationById(id);
    }

    @PostMapping("DeliveryInformation")
    public DeliveryInformation postDeliveryInformation(@Valid @RequestBody DeliveryInformation deliveryInformation){
        return deliveryInformationService.saveDeliveryInformation(deliveryInformation);
    }

    @PutMapping("DeliveryInformation/{id}")
    public DeliveryInformation updateDeliveryInformation(@Valid @RequestBody DeliveryInformation deliveryInformation,
                                                         @PathVariable("id") Integer id){
        return deliveryInformationService.updateDeliveryInformation(id, deliveryInformation);
    }

}
