package com.example.bankproject.JDBC_template_example.dao;

import com.example.bankproject.JDBC_template_example.records.Passport_rec;
import com.example.bankproject.JDBC_template_example.mappers.PassportMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PassportDAO {

   private final JdbcTemplate jdbcTemplate;
   private final PassportMapper passportMapper;

    public PassportDAO(JdbcTemplate jdbcTemplate, PassportMapper passportMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.passportMapper = passportMapper;
    }

    public List<Passport_rec> getPassports()
    {
        String sql = "SELECT * FROM Passports";

         return  jdbcTemplate.query(sql, passportMapper);
    }

    public Optional<Passport_rec> getPassport(String series, String number)
    {
        String sql = "SELECT * FROM Passports where series = ? AND number = ?";

       return jdbcTemplate.query(sql, passportMapper, series, number)
                .stream()
                .findFirst();

    }

}
