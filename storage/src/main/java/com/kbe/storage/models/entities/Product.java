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

}
