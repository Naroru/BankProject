package com.example.bankproject.JDBC_template_example.service;

import com.example.bankproject.JDBC_template_example.dao.CompanyDAO;
import com.example.bankproject.JDBC_template_example.records.Company_rec;
import com.example.bankproject.exceptions.ObjectNotFound;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyDAO companyDAO;

    public CompanyService(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public Company_rec getCompany(int id)
    {
        return companyDAO.getCompany(id)
                .orElseThrow(() -> new ObjectNotFound("Company is not found"));
    }
}
