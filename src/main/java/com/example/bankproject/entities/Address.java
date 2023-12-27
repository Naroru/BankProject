package com.example.bankproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id; //todo обычно Long. в реальной жизни int по диапозону может не хватить

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column(name = "building_number")
    private String buildingNunber;

    @Column(name = "room_number")
    private int roomNumber;

}


