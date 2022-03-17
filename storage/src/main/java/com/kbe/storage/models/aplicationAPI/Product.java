package com.kbe.storage.models.aplicationAPI;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int productId;
    private String name;
    private double price;
    private String manufacturer;
    private double displaySize;
    private String color;
    private int refreshRate;
    private String displayInterface;
    private String resolution;
    private double weight;
    private int reactionTime;
}
