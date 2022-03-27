package com.kbe.storage.controller;

import com.kbe.storage.models.aplicationAPI.DeliveryInfoModel;
import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.services.DeliveryInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class InfoController {


    private final DeliveryInformationService infoService;

    @GetMapping("delivery-information/{id}")
    public DeliveryInfoModel getDeliveryInformation(@PathVariable("id") Integer id){
        return infoService.convertEntityToModel(
                infoService.findDeliveryInformationById(id));
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
