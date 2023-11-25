package com.example.bankproject.services;

import com.example.bankproject.entities.Company;
import com.example.bankproject.exceptions.ObjectNotFound;
import com.example.bankproject.repositories.CompanyRespository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRespository companyRespository;

    public CompanyService(CompanyRespository companyRespository) {
        this.companyRespository = companyRespository;
    }

    public Company getCompany(int id) {

        Company company= companyRespository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFound(String.format("Company with id = %d was not found",id))
                );

        return company;
    }

    public void saveCompany(Company company)
    {
         //метод также используется для обновления данных. Мб стоит сделать отдельный метод,  чтобы выполнить проверку
        //что обновляемый объект есть в БД
        companyRespository.save(company);
    }

    public void deleteCompany(int id) {

        Company company = companyRespository.findById(id)
                .orElseThrow(() -> new ObjectNotFound(String.format("Company with id = %d was not found",id)));

        companyRespository.delete(company);

    }
}
