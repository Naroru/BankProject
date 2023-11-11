package com.example.bankproject.JDBC_template_example.dao;

import com.example.bankproject.JDBC_template_example.mappers.CompanyMapper;
import com.example.bankproject.JDBC_template_example.records.Company_rec;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CompanyDAO {

    private final  JdbcTemplate jdbcTemplate;
    private final CompanyMapper companyMapper;

    public CompanyDAO(JdbcTemplate jdbcTemplate, CompanyMapper companyMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.companyMapper = companyMapper;
    }

    public Optional<Company_rec> getCompany(int id)
    {
        String sql = "SELECT * FROM Companies WHERE id = ?";

        return jdbcTemplate.query(sql,companyMapper, id)
                .stream()
                .findFirst();

    }
}
