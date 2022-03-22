package com.kbe.storage.models.aplicationAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryInfoModel {

    @Min(0)
    private int productId;

    @Min(1)
    @Max(100)
    private int deliveryTimeDays;

    @Min(1)
    @Max(9999)
    private int amount;

    @NotNull
    private Location productLocation;

}
