package com.example.bankproject.JDBC_template_example.mappers;

import com.example.bankproject.JDBC_template_example.records.User_rec;
import com.example.bankproject.JDBC_template_example.service.CompanyService;
import com.example.bankproject.JDBC_template_example.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User_rec> {

    private final PassportService passportService;
    private final CompanyService companyService;

    
    public UserMapper(PassportService passportService, CompanyService companyService) {
        this.passportService = passportService;
        this.companyService = companyService;
    }

    @Override
    public User_rec mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        return new User_rec(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("INN"),
                resultSet.getString("phone"),
                resultSet.getString("snils"),
                //null,
                companyService.getCompany(resultSet.getInt("fk_company")),
               // null,
                passportService.getPassport(resultSet.getString("passport_series"), resultSet.getString("passport_number")),
                null

        );


    }
}
