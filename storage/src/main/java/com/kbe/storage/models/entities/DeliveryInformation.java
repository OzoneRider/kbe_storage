package com.kbe.storage.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "delivery_information")
public class DeliveryInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "DELIVERY_TIME")
    private int deliveryTimeDays;
    @Column(name = "AMOUNT")
    private int amount;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOME_NR")
    private String homeNr;
    @Column(name = "POSTAL_CODE")
    private String postalCode;

    public DeliveryInformation() {
    }

    public DeliveryInformation(int productId, int deliveryTimeDays, int amount, String country, String city, String street, String homeNr, String postalCode) {
        this.productId = productId;
        this.deliveryTimeDays = deliveryTimeDays;
        this.amount = amount;
        this.country = country;
        this.city = city;
        this.street = street;
        this.homeNr = homeNr;
        this.postalCode = postalCode;
    }

    public long getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getDeliveryTimeDays() {
        return deliveryTimeDays;
    }

    public void setDeliveryTimeDays(int deliveryTimeDays) {
        this.deliveryTimeDays = deliveryTimeDays;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNr() {
        return homeNr;
    }

    public void setHomeNr(String homeNr) {
        this.homeNr = homeNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}