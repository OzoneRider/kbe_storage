package com.kbe.storage.repositories;

import com.kbe.storage.models.entities.DeliveryInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryInformationRepository extends JpaRepository<DeliveryInformationEntity, Long> {
}
