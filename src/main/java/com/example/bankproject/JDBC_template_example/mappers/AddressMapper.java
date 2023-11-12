package com.example.bankproject.JDBC_template_example.mappers;

import com.example.bankproject.JDBC_template_example.records.Address_rec;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AddressMapper implements RowMapper<Address_rec> {

    @Override
    public Address_rec mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Address_rec( rs.getInt("id"),
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("street"),
                rs.getString("building_number"),
                rs.getInt("room_number")
        );
    }
}
