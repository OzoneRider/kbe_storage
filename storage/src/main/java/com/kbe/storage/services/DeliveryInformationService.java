package com.kbe.storage.services;

import com.kbe.storage.repositories.DeliveryInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryInformationService {

    @Autowired
    DeliveryInformationRepository deliveryInformationRepository;

}
