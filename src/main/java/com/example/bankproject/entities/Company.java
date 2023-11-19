package com.example.bankproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Companies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column
    private  String name;

    @Column(name = "inn")
    private String INN;

    @Column
    private String phone;


    @ManyToOne
    @JoinColumn(name = "fk_address")
    private Address address;


}
