package com.example.bankproject.controllers;


import com.example.bankproject.services.AddressService;
import com.example.bankproject.entities.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("{id}")//todo в итоге у тебя ручка будет выглядеть так api/addresses{id}. раставь где нужно /
    public Address getAddress(@PathVariable int id)
    {
        return addressService.getAddress(id);
    }

    @PostMapping
    public void addAddress(@RequestBody Address address) //todo обычно фронту в ответ нужно возвращать обект. созданную запись с присвоенным ей ИД
    //todo в @RequestBody передаешь entity, нужно использовать dto и мапперы. Маппер можно написать самостоятельно либо использовать какие либо либы  например mapstruct или selma
    {
        addressService.addAddress(address);
    }

    @PutMapping
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
