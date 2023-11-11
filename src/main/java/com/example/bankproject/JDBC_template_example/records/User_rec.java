package com.example.bankproject.JDBC_template_example.records;

public record User_rec(Integer id,
                       String name,
                       String surname,
                       String INN,
                       String phone,
                       String snils,
                       Company_rec company,
                       Passport_rec passport,
                       Address_rec address) {

}
