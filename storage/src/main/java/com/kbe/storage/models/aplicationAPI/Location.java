package com.kbe.storage.models.aplicationAPI;

import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String country;
    private String city;
    private String street;
    private String homeNr;
    private String postalCode;
}
