package com.example.bankproject.controllers;

import com.example.bankproject.entities.Company;
import com.example.bankproject.services.CompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("{id}")
    public Company getCompany(@PathVariable int id)
    {
        return companyService.getCompany(id);
    }

    @PostMapping
    public void addCompany(@RequestBody Company company)
    {
        companyService.saveCompany(company);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company)
    {
        companyService.saveCompany(company);
    }

    @DeleteMapping("{id}")
    public void deleteCompany(@PathVariable int id)
    {
        companyService.deleteCompany(id);
    }
}
