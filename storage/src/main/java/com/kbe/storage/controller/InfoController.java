package com.kbe.storage.controller;

import com.kbe.storage.models.aplicationAPI.DeliveryInfoModel;
import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.services.DeliveryInformationService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/")
public class InfoController {


    private final DeliveryInformationService infoService;

    public InfoController(DeliveryInformationService infoService){
        this.infoService = infoService;
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

    @PutMapping("delivery-information")
    public DeliveryInfoModel updateDeliveryInformation(@Valid @RequestBody DeliveryInformation deliveryInformation){
        return infoService.convertEntityToModel(
                infoService.updateDeliveryInformation(deliveryInformation));
    }

}
