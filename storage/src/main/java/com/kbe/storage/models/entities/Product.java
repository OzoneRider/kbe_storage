package com.kbe.storage.models.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @Min(0)
    private int id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "PRICE_IN_EURO")
    @DecimalMin("10.0")
    @DecimalMax("5000.0")
    @Digits(integer = 4, fraction = 2)
    private BigDecimal priceEuro;

    @Column(name = "MANUFACTURER")
    @NotNull
    private String manufacturer;

    @Column(name = "DISPLAY_SIZE_IN_INCHES")
    @DecimalMin("10.0")
    @DecimalMax("50.0")
    @Digits(integer = 2, fraction = 1)
    private BigDecimal displaySizeInches;

    @Column(name = "COLOR")
    @NotNull
    private String color;

    @Column(name = "REFRESH_RATE_IN_HZ")
    @Min(30)
    @Max(360)
    private int refreshRateHz;

    @Column(name = "WEIGHT_IN_KG")
    @DecimalMin("0.25")
    @DecimalMax("15.0")
    @Digits(integer = 2, fraction = 3)
    private BigDecimal weightKg;

    @Column(name = "REACTION_TIME_IN_MS")
    @Min(1)
    @Max(10)
    private int reactionTimeMs;

    @NotNull
    @Column(name = "DISPLAY_INTERFACE")
    private String displayInterface;

    @Column(name = "RESOLUTION")
    @NotNull
    private String resolution;


    @Override
    public final boolean equals(Object o){

        if(o == this)
            return true;
        if(!(o instanceof Product))
            return false;

        Product product = (Product) o;

        boolean nameEquals = (this.name == null && product.name == null)
                || (this.name != null && this.name.equals(product.name));
        boolean priceEquals = (this.priceEuro == null && product.priceEuro == null)
                || (this.priceEuro != null && this.priceEuro.compareTo(product.priceEuro) == 0);
        boolean manufacturerEquals = (this.manufacturer == null && product.manufacturer == null)
                || (this.manufacturer != null && this.manufacturer.equals(product.manufacturer));
        boolean displaySizeEquals = (this.displaySizeInches == null && product.displaySizeInches == null)
                || (this.displaySizeInches != null && this.displaySizeInches.compareTo(product.displaySizeInches) == 0);
        boolean colorEquals = (this.color == null && product.color == null)
                || (this.color != null && this.color.equals(product.color));
        boolean refreshRateEquals = this.refreshRateHz == product.refreshRateHz;
        boolean weightEquals = (this.weightKg == null && product.weightKg == null)
                || (this.weightKg != null && this.weightKg.compareTo(product.weightKg) == 0);
        boolean reactionTimeEquals = this.reactionTimeMs == product.reactionTimeMs;
        boolean displayInterfaceEquals = (this.displayInterface == null && product.displayInterface == null)
                || (this.displayInterface != null && this.displayInterface.equals(product.displayInterface));
        boolean resolutionEquals = (this.resolution == null && product.resolution == null)
                || (this.resolution != null && this.resolution.equals(product.resolution));

        return nameEquals && priceEquals && manufacturerEquals && displaySizeEquals && colorEquals
                && refreshRateEquals && weightEquals && reactionTimeEquals && displayInterfaceEquals && resolutionEquals;
    }

    @Override
    public final int hashCode(){
        int result = 17;
        if(name != null){
            result = 31 * result + name.hashCode();
        }
        if(priceEuro != null){
            result = 31 * result + priceEuro.hashCode();
        }
        if(manufacturer != null){
            result = 31 * result + manufacturer.hashCode();
        }
        if(displaySizeInches != null){
            result = 31 * result + displaySizeInches.hashCode();
        }
        if(color != null){
            result = 31 * result + color.hashCode();
        }
        if(refreshRateHz >= 30){
            result = 31 * result + refreshRateHz;
        }
        if(weightKg != null){
            result = 31 * result + weightKg.hashCode();
        }
        if(reactionTimeMs > 0){
            result = 31 * result + reactionTimeMs;
        }
        if(displayInterface != null){
            result = 31 * result + displayInterface.hashCode();
        }
        if(resolution != null){
            result = 31 * result + resolution.hashCode();
        }
        return result;
    }

    @Override
    public String toString(){

        return "{\n\t\"name\":\" "+this.name+"\",\n" +
                "\t\"priceEuro\":\" "+this.priceEuro.toString()+"\",\n" +
                "\t\"manufacturer\":\" "+this.manufacturer+"\",\n"+
                "\t\"displaySizeInches\":\" "+this.displaySizeInches.toString()+"\",\n"+
                "\t\"color\":\" "+this.color+"\"\n"+
                "\t\"refreshRateHz\":\" "+this.refreshRateHz+"\",\n" +
                "\t\"weightKg\":\" "+this.weightKg.toString()+"\",\n"+
                "\t\"reactionTimeMs\":\" "+this.reactionTimeMs+"\",\n"+
                "\t\"displayInterface\":\" "+this.displayInterface+"\"\n"+
                "\t\"resolution\":\" "+this.resolution+"\"\n"+
                "}\n";
    }
}
