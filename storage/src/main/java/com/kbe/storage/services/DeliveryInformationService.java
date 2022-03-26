package com.kbe.storage.services;

import com.kbe.storage.exceptions.DataNotFoundException;
import com.kbe.storage.models.aplicationAPI.DeliveryInfoModel;
import com.kbe.storage.models.aplicationAPI.Location;
import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.repositories.DeliveryInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryInformationService {

    @Autowired
    DeliveryInformationRepository deliveryInformationRepository;

    public  DeliveryInformation findDeliveryInformationByProductId(int id){
        return deliveryInformationRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id));
    }

    public DeliveryInformation saveDeliveryInformation(DeliveryInformation info){
        if(deliveryInformationRepository.save(info) == null)
            throw new DataNotFoundException(info.getId());
        return info;
    }

    public DeliveryInformation updateDeliveryInformation(DeliveryInformation info){
        DeliveryInformation temp = deliveryInformationRepository.findById(info.getId())
                .orElseThrow(() -> new DataNotFoundException(info.getId()));

        return deliveryInformationRepository.save(info);
    }

    public DeliveryInformation convertModelToEntity(DeliveryInfoModel infoModel){

        if(infoModel == null)
            return null;

        return new DeliveryInformation(infoModel.getProductId(), infoModel.getDeliveryTimeDays(), infoModel.getAmount(),
                infoModel.getProductLocation().getCountry(), infoModel.getProductLocation().getCity(),
                infoModel.getProductLocation().getStreet(), infoModel.getProductLocation().getHomeNr(),
                infoModel.getProductLocation().getPostalCode());
    }

    public DeliveryInfoModel convertEntityToModel(DeliveryInformation info){

        if(info == null)
            return null;

        return new DeliveryInfoModel(info.getId(), info.getDeliveryTimeDays(), info.getAmount(),
                new Location(info.getCountry(), info.getCity(), info.getStreet(), info.getHomeNr(), info.getPostalCode()));
    }

}
