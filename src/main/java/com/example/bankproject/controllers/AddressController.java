package com.example.bankproject.controllers;

import com.example.bankproject.JDBC_template_example.records.Address_rec;
import com.example.bankproject.JDBC_template_example.service.AddressServices;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/addresses")
public class AddressController {

    private  final AddressServices addressServices;

    public AddressController(AddressServices addressServices) {
        this.addressServices = addressServices;
    }


    @GetMapping
    public List<Address_rec> getAddresses() {

        return addressServices.getAddresses();

    }

    @GetMapping("{id}")
    public Address_rec getAddress(@PathVariable("id") int id)
    {
        return addressServices.getAddress(id);

    }

    @PostMapping
    public void addAddress(@RequestBody Address_rec address_rec)
    {
        addressServices.addAddress(address_rec);
    }

/*    @PutMapping("{id}")
    public void updateAddress(@PathVariable("id") int id,
                              @RequestBody SomeStructure someStruct)*/

    @PutMapping
    public void updateAddress(@RequestBody Address_rec address)
    {
        addressServices.updateAddress(address);
    }

    @DeleteMapping("{id}")
public void deleteAddress(@PathVariable("id") int id)
    {
        addressServices.deleteAddress(id);
    }
}
