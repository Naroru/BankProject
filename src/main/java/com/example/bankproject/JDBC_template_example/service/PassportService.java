package com.example.bankproject.JDBC_template_example.service;

import com.example.bankproject.JDBC_template_example.dao.PassportDAO;
import com.example.bankproject.JDBC_template_example.records.Passport_rec;
import com.example.bankproject.exceptions.ObjectNotFound;
import org.springframework.stereotype.Service;

@Service
public class PassportService {

    private final PassportDAO passportDAO;

    public PassportService(PassportDAO passportDAO) {
        this.passportDAO = passportDAO;
    }


    public Passport_rec getPassport(String series, String number) {
        return passportDAO.getPassport(series, number)
                .orElseThrow(() -> new ObjectNotFound("Passport not found"));
    }
}
