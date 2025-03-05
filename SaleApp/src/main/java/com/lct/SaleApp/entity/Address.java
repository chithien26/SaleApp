package com.lct.SaleApp.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String fullName;
    String phoneNumber;
    String specificAddress;
    String ward;
    String district;
    String city;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public Address(String fullName, String phoneNumber, String specificAddress, String ward, String district, String city, User user) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.specificAddress = specificAddress;
        this.ward = ward;
        this.district = district;
        this.city = city;
        this.user = user;
    }

    public String toString(){
        return specificAddress + ", " + ward + ", " + district + ", " + city;
    }

}
