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

    @Override
    public final boolean equals(Object o){

        if(o == this)
            return true;
        if(!(o instanceof DeliveryInfoModel))
            return false;
        DeliveryInfoModel infoModel = (DeliveryInfoModel) o;

        boolean locationEquals = (this.productLocation == null && infoModel.productLocation == null)
                || (this.productLocation != null && this.productLocation.equals(infoModel.productLocation));
        boolean deliveryTimeEquals = this.deliveryTimeDays == infoModel.deliveryTimeDays;
        boolean amountEquals = this.amount == infoModel.amount;

        return locationEquals && deliveryTimeEquals && amountEquals;
    }

    public final int hashCode(){
        int result = 17;
        if(productLocation != null){
            result = 31 * result + productLocation.hashCode();
        }
        if(deliveryTimeDays > 0){
            result = 31 * result + deliveryTimeDays;
        }
        if(amount >= 0){
            result = 31 * result + amount;
        }

        return result;
    }
}
