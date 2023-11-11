package com.example.bankproject.JDBC_template_example.mappers;

import com.example.bankproject.JDBC_template_example.records.Company_rec;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CompanyMapper implements RowMapper<Company_rec> {


    @Override
    public Company_rec mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Company_rec(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("inn"),
                rs.getString("phone"));
    }
}
