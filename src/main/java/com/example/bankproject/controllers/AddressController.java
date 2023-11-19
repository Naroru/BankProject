package com.example.bankproject.controllers;


import com.example.bankproject.Service.AddressService;
import com.example.bankproject.entities.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api/users")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<Address> get()
    {
        addressService.getAddresses()
    }



}
