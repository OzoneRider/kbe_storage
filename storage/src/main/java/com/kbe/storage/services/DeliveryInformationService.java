package com.kbe.storage.services;

import com.kbe.storage.models.aplicationAPI.DeliveryInfoModel;
import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.repositories.DeliveryInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryInformationService {

    @Autowired
    DeliveryInformationRepository deliveryInformationRepository;

    public DeliveryInformation saveDeliveryInformation(DeliveryInformation deliveryInformation){
        return deliveryInformationRepository.save(deliveryInformation);
    }

    public  DeliveryInformation findDeliveryInformationById(int id){
        return deliveryInformationRepository.findByProductId(id);
    }

    public DeliveryInformation updateDeliveryInformation(int id, DeliveryInformation deliveryInformation){
        DeliveryInformation info = deliveryInformationRepository.findByProductId(id);
        info.setAmount(deliveryInformation.getAmount());
        info.setDeliveryTimeDays(deliveryInformation.getDeliveryTimeDays());
        return deliveryInformationRepository.save(info);
    }

    public DeliveryInformation convertModelToEntity(DeliveryInfoModel infoModel){
        return new DeliveryInformation(infoModel.getProductId(), infoModel.getDeliveryTimeDays(), infoModel.getAmount(),
                infoModel.getProductLocation().getCountry(), infoModel.getProductLocation().getCity(),
                infoModel.getProductLocation().getStreet(), infoModel.getProductLocation().getHomeNr(),
                infoModel.getProductLocation().getPostalCode());
    }

}
