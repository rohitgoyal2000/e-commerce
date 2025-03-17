package com.e_commerce.e_commerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

        private String fullName;
        private String email;
        private String phoneNumber;
        private String address;
        private String city;
        private String country;
        private String zipCode;

    public UserDTO(String fullName, String email, String phoneNumber, String address, String city, String city1, String zipCode) {
        this.address = address;
        this.city = city;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.zipCode = zipCode;

    }
}
