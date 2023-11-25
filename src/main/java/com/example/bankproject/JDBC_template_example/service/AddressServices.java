package com.example.bankproject.JDBC_template_example.service;


import com.example.bankproject.JDBC_template_example.dao.AddressDAO;
import com.example.bankproject.JDBC_template_example.records.Address_rec;
import com.example.bankproject.exceptions.ObjectNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AddressService_JDBC")
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
            throw new IllegalStateException("Address wasn't added");
        }
    }

    public void updateAddress(Address_rec address) {

        Optional<Address_rec> addressContainer = addressDAO.getAddress(address.id());

        addressContainer.ifPresentOrElse(address_rec ->
            {
                int result = addressDAO.updateAddress(address);
                if (result != 1) throw new ObjectNotFound("Address with id = " + address.id() + "not found");
             }, () -> {
            throw new IllegalArgumentException("Smthg went wrong");
        });
    }

    public void deleteAddress(int id) {

        Optional<Address_rec> addressContainer = addressDAO.getAddress(id);

        addressContainer.ifPresentOrElse(address ->
                {
                    int result = addressDAO.deleteAddress(id);

                    if (result != 1)
                        throw new IllegalStateException("Address wasn't not deleted. Smth went wrong");
                }, () -> {
                    throw new ObjectNotFound(String.format("Address with id = %d wasn't found", id));
                }
        );




    }
}
