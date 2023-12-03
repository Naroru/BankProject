package com.example.bankproject.services;

import com.example.bankproject.dao.AddressDAO;
import com.example.bankproject.entities.Address;
import com.example.bankproject.exceptions.ObjectNotFound;
import com.example.bankproject.repositories.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressDAO addressDAO;
    private final AddressRepository addressRepository;

    public AddressService(AddressDAO addressDAO, AddressRepository addressRepository) {
        this.addressDAO = addressDAO;
        this.addressRepository = addressRepository;
    }

    public Address getAddress(int id) {


       // return addressDAO.getAddress(id);

  /*      if (id < 0)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(addressRepository.findById(id).get());
*/

       return addressRepository.findById(id).orElseThrow(
                () -> new ObjectNotFound(String.format("Address with id = %d not found", id)));
    }

    public void addAddress(Address address) {
        //требуются ли здесь проверки, что адрес успешно сохранен?
        //addressDAO.save(address);
       addressRepository.save(address);
    }

    public void updateAddress(Address address) {
        //требуются ли здесь проверки, что адрес найден и изменен?
         addressRepository.save(address);
    }

    public void deleteAddress(int id)
    {
        addressRepository.deleteById(id);
    }

}
