package com.example.bankproject.JDBC_template_example.service;


import com.example.bankproject.JDBC_template_example.dao.AddressDAO;
import com.example.bankproject.JDBC_template_example.records.Address_rec;
import com.example.bankproject.exceptions.ObjectNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServices {

    private final AddressDAO addressDAO;

    public AddressServices(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }


    public List<Address_rec> getAddresses() {

        return  addressDAO.getAddresses();
    }

    public Address_rec getAddress(int id) {

        return addressDAO.getAddress(id)
                .orElseThrow(() -> new ObjectNotFound("address with id = "+id+" not found"));
    }

    public void addAddress(Address_rec address_rec)
    {
        int result = addressDAO.addAddress(address_rec);
        if (result != 1) {
            throw new IllegalStateException("address wasn't added");
        }
    }
}
