package com.kbe.storage.controller;

import com.kbe.storage.models.aplicationAPI.DeliveryInfoModel;
import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.models.entities.Product;
import com.kbe.storage.services.CsvImportService;
import com.kbe.storage.services.DeliveryInformationService;
import com.kbe.storage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class StorageController {

    @Autowired
    CsvImportService csvImportService;
    @Autowired
    DeliveryInformationService infoService;
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

    @GetMapping("delivery-information/{id}")
    public DeliveryInfoModel getDeliveryInformation(@PathVariable("id") Integer id){
        return infoService.convertEntityToModel(
                infoService.findDeliveryInformationByProductId(id));
    }

    @PostMapping("delivery-information")
    public DeliveryInfoModel postDeliveryInformation(@Valid @RequestBody DeliveryInfoModel info){
        return infoService.convertEntityToModel(
                infoService.saveDeliveryInformation(
                infoService.convertModelToEntity(info)));
    }

    @PutMapping("delivery-information/{id}")
    public DeliveryInfoModel updateDeliveryInformation(@Valid @RequestBody DeliveryInformation deliveryInformation,
                                                         @PathVariable("id") Integer id){
        return infoService.convertEntityToModel(
                infoService.updateDeliveryInformation(id, deliveryInformation));
    }

}
