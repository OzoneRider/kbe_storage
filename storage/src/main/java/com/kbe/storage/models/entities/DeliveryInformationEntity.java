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
@Table(name = "delivery_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryInformationEntity {

    @Id
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

}
