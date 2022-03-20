package com.kbe.storage.repositories;

import com.kbe.storage.models.entities.DeliveryInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryInformationRepository extends JpaRepository<DeliveryInformation, Long> {

    public DeliveryInformation findByProductId(int productId);
}
