package com.example.bankproject.controllers;


import com.example.bankproject.services.AddressService;
import com.example.bankproject.entities.Address;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/addresses")

@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping("{id}")
    public Address getAddress(@PathVariable int id)
    {
        return  addressService.getAddress(id);
    }

    @PostMapping()
    public void addAddress(@RequestBody Address address)
    {
        addressService.addAddress(address);
    }

    @PutMapping()
    public void updateAddress(@RequestBody Address address)
    {
        addressService.updateAddress(address);
    }

    @DeleteMapping("{id}")
    public void deleteAddressById(@PathVariable int id)
    {
        addressService.deleteAddress(id);
    }



}
