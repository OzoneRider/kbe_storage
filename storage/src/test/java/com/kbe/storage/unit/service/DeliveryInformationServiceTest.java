package com.kbe.storage.unit.service;

import com.kbe.storage.exceptions.DataNotFoundException;
import com.kbe.storage.models.aplicationAPI.DeliveryInfoModel;
import com.kbe.storage.models.aplicationAPI.Location;
import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.repositories.DeliveryInformationRepository;
import com.kbe.storage.services.DeliveryInformationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DeliveryInformationServiceTest {

    private DeliveryInformationRepository repository = Mockito.mock(DeliveryInformationRepository.class);

    private DeliveryInformationService service;

    private DeliveryInformation entity;

    private DeliveryInfoModel model;

    @BeforeEach
    void initService(){
        service = new DeliveryInformationService(repository);
        entity = new DeliveryInformation(4, 2, 999,
                "country", "city", "street", "44", "34435");
        model = new DeliveryInfoModel(4, 2, 999, new Location("country", "city",
                "street","homeNr","postalCode"));
    }

    @Test
    void saveDeliveryInformationTest(){
        when(repository.save(any(DeliveryInformation.class))).then(returnsFirstArg());
        DeliveryInformation savedInfo = service.saveDeliveryInformation(entity);
        assertThat(entity.equals(savedInfo));
    }

    @Test
    void getDeliveryInformationTest(){
        Assertions.assertThatExceptionOfType(DataNotFoundException.class).isThrownBy(() -> {
            DeliveryInformation newInfo = service.findDeliveryInformationById(4);
        }).withMessage("Data with Id 4 not found");
    }

    @Test
    void entityToModelTest(){
        DeliveryInfoModel modelTemp = service.convertEntityToModel(entity);
        assertThat(modelTemp.getProductLocation().getCity().equals(entity.getCity()));
        assertThat(modelTemp.getProductLocation().getPostalCode().equals(entity.getPostalCode()));
    }

    @Test
    void modelToEntityTest(){
        DeliveryInformation infoTemp = service.convertModelToEntity(model);
        assertThat(infoTemp.getCountry().equals(model.getProductLocation().getCountry()));
        assertThat(infoTemp.getHomeNr().equals(model.getProductLocation().getHomeNr()));
    }
}
