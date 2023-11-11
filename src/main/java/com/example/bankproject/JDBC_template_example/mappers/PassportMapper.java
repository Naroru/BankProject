package com.example.bankproject.JDBC_template_example.mappers;

import com.example.bankproject.JDBC_template_example.records.Passport_rec;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PassportMapper implements RowMapper<Passport_rec> {

    @Override
    public Passport_rec mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        return new Passport_rec(
                resultSet.getString("series"),
                resultSet.getString("number"),
                resultSet.getDate("date_of_issue").toLocalDate(),
                resultSet.getString("issued_by")
        );
    }

}
