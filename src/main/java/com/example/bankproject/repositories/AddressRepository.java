package com.example.bankproject.repositories;

import com.example.bankproject.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> { //todo Long

}
