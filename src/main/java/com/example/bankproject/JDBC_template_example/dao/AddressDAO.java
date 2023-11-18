package com.example.bankproject.JDBC_template_example.dao;

import com.example.bankproject.JDBC_template_example.mappers.AddressMapper;
import com.example.bankproject.JDBC_template_example.records.Address_rec;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressDAO {

    private final JdbcTemplate jdbcTemplate;
    private final AddressMapper addressMapper;

    public AddressDAO(JdbcTemplate jdbcTemplate, AddressMapper addressMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.addressMapper = addressMapper;
    }

    public List<Address_rec> getAddresses() {

        String sql = "SELECT * FROM addresses";

        return jdbcTemplate.query(sql,addressMapper);
    }

    public Optional<Address_rec> getAddress(int id) {

        String sql = "SELECT * FROM Addresses WHERE id =?";

        return jdbcTemplate.query(sql, addressMapper,id)
                .stream()
                .findAny();
    }


    public int addAddress(Address_rec address)
    {
            String sql = "INSERT INTO addresses" +
                    "(country, city, street, building_number, room_number) " +
                    "VALUES (?,?,?,?,?)";

            return jdbcTemplate.update(sql,
                    address.country(),
                    address.city(),
                    address.street(),
                    address.builderNumber(),
                    address.roomNumber());

    }

    public int updateAddress(Address_rec address)
    {
        String sql = "UPDATE Addresses SET country = ?, city  = ?, street = ?, building_number = ?, room_number = ?" +
                " WHERE id = ?";

        return jdbcTemplate.update(sql,
                address.country(),
                address.city(),
                address.street(),
                address.builderNumber(),
                address.roomNumber(),
                address.id());
    }

    public int deleteAddress(int id) {

       String sql = "DELETE FROM Addresses WHERE id = ?";
       return jdbcTemplate.update(sql,id);
    }
}
