package com.example.bankproject.JDBC_template_example.records;

import java.time.LocalDate;

public record Passport_rec(String series,
                           String number,
                           LocalDate dateOfIssue,
                           String issuedBy) {
}


