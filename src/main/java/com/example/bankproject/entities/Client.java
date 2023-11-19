package com.example.bankproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "INN")
    private String INN;

    @Column(name = "phone")
    private String phone;

    @Column(name = "snils")
    private String snils;

    @ManyToOne
    @JoinColumn(name = "fk_company")
    private Company company;

    @OneToOne
    @JoinColumn(name = "fk_passport")
    private Passport passport;

    @OneToOne
    @JoinColumn(name = "fk_address")
    private Address address;



}

