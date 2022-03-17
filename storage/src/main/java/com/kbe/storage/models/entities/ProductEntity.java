package com.kbe.storage.models.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE_IN_EURO")
    private double price;
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Column(name = "DISPLAY_SIZE_IN_INCHES")
    private double displaySize;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "REFRESH_RATE_IN_HZ")
    private int refreshRate;
    @Column(name = "DISPLAY_INTERFACE")
    private String displayInterface;
    @Column(name = "RESOLUTION")
    private String resolution;
    @Column(name = "WEIGHT_IN_KG")
    private double weight;
    @Column(name = "REACTION_TIME_IN_MS")
    private int reactionTime;
}
