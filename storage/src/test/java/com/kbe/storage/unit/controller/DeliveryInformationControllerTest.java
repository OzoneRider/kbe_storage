package com.kbe.storage.unit.controller;

import com.kbe.storage.controller.InfoController;
import com.kbe.storage.models.aplicationAPI.DeliveryInfoModel;
import com.kbe.storage.models.aplicationAPI.Location;
import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.services.DeliveryInformationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

public class DeliveryInformationControllerTest {

    private DeliveryInformationService service = Mockito.mock(DeliveryInformationService.class);

    private InfoController controller;

    private DeliveryInformation entity;

    private DeliveryInfoModel model;

    @BeforeEach
    void setUp(){
        this.controller = new InfoController(service);

        entity = new DeliveryInformation(4,3,99,
                "country","city","street","homeNr","postalCode");

        model = new DeliveryInfoModel(4, 3, 99,
                new Location("country","city","street","homeNr","postalCode"));
    }

    @Test
    void getDeliveryInformationTest(){
        when(service.findDeliveryInformationById(4)).thenReturn(entity);
        when(service.convertEntityToModel(any(DeliveryInformation.class))).thenReturn(model);
        DeliveryInfoModel result = controller.getDeliveryInformation(4);
        assertThat(model.equals(result));
    }

    @Test
    void postDeliveryInformationTest(){
        when(service.convertEntityToModel(any(DeliveryInformation.class))).thenReturn(model);
        when(service.convertModelToEntity(any(DeliveryInfoModel.class))).thenReturn(entity);
        when(service.saveDeliveryInformation(any(DeliveryInformation.class))).thenReturn(entity);
        DeliveryInfoModel result = controller.postDeliveryInformation(model);
        assertThat(model.equals(result));
    }

    @Test
    void putDeliveryInformationTest(){
        when(service.convertEntityToModel(any(DeliveryInformation.class))).thenReturn(model);
        when(service.saveDeliveryInformation(any(DeliveryInformation.class))).thenReturn(entity);
        DeliveryInfoModel result = controller.updateDeliveryInformation(entity);
        assertThat(model.equals(result));
    }
}
