package com.example.bankproject.repositories;

import com.example.bankproject.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Integer> {

}
