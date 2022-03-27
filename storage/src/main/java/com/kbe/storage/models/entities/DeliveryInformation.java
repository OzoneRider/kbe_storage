package com.kbe.storage.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "delivery_information")
public class DeliveryInformation {

    @Id
    @Column(name = "PRODUCT_ID")
    private int id;
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

    public DeliveryInformation(int id, int deliveryTimeDays, int amount, String country, String city, String street, String homeNr, String postalCode) {
        this.id = id;
        this.deliveryTimeDays = deliveryTimeDays;
        this.amount = amount;
        this.country = country;
        this.city = city;
        this.street = street;
        this.homeNr = homeNr;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public final boolean equals(Object o){

        if(o == this)
            return true;
        if(!(o instanceof DeliveryInformation))
            return false;
        DeliveryInformation deliveryInformation = (DeliveryInformation) o;

        boolean deliveryTimeEquals = this.deliveryTimeDays == deliveryInformation.deliveryTimeDays;
        boolean amountEquals = this.amount == deliveryInformation.amount;
        boolean countryEquals = (this.country == null && deliveryInformation.country == null)
                || (this.country != null && this.country.equals(deliveryInformation.country));
        boolean cityEquals = (this.city == null && deliveryInformation.city == null)
                || (this.city != null && this.city.equals(deliveryInformation.city));
        boolean streetEquals = (this.street == null && deliveryInformation.street == null)
                || (this.street != null && this.street.equals(deliveryInformation.street));
        boolean homeNrEquals = (this.homeNr == null && deliveryInformation.homeNr == null)
                || (this.homeNr != null && this.homeNr.equals(deliveryInformation.homeNr));
        boolean postalCodeEquals = (this.postalCode == null && deliveryInformation.postalCode == null)
                || (this.postalCode != null && this.postalCode.equals(deliveryInformation.postalCode));

        return deliveryTimeEquals && amountEquals && countryEquals && cityEquals &&
                streetEquals && homeNrEquals && postalCodeEquals;
    }

    public final int hashCode(){
        int result = 17;
        if(deliveryTimeDays > 0){
            result = 31 * result + deliveryTimeDays;
        }
        if(amount >= 0){
            result = 31 * result + amount;
        }
        if(country != null){
            result = 31 * result + country.hashCode();
        }
        if(city != null){
            result = 31 * result + city.hashCode();
        }
        if(street != null){
            result = 31 * result + street.hashCode();
        }
        if(homeNr != null){
            result = 31 * result + homeNr.hashCode();
        }
        if(postalCode != null){
            result = 31 * result + postalCode.hashCode();
        }

        return result;
    }
}
