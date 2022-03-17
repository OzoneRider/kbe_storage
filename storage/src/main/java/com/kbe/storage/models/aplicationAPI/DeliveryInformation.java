package com.kbe.storage.models.aplicationAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryInformation {

    private int productId;
    private int deliveryTimeDays;
    private int amount;
}
