package com.example.bankproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "passports")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "seria")
    private String series;

    @Column
    private String number;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Column(name = "issued_by")
    private String issuedBy;

}
