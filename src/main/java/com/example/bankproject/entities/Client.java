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
    private String INN; //todo code style inn

    @Column(name = "phone")
    private String phone;

    @Column(name = "snils")
    private String snils;

    @ManyToOne
    @JoinColumn(name = "fk_company") //todo обычно company_id
    private Company company;

    @OneToOne
    @JoinColumn(name = "fk_passport")
    private Passport passport;  //todo OneToMany у клиента могут быть старые неактивные паспорта

    @OneToOne
    @JoinColumn(name = "fk_address")
    private Address address;



}

