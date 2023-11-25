package com.example.bankproject.services;

import com.example.bankproject.entities.Passport;
import com.example.bankproject.exceptions.ObjectNotFound;
import com.example.bankproject.repositories.PassportRepository;
import org.springframework.stereotype.Service;

@Service
public class PassportService {

    private final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport getPassport(int id)
    {
        return passportRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFound(String.format("Passport with id = %d was not found", id))
                        );
    }

    public void savePassport(Passport passport) {

        //проверка для случая update что пасспорт существует?
        passportRepository.save(passport);
    }

    public void deletePassport(int id) {

        Passport passport = passportRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFound(String.format("Passport with id = %d was not found", id))
                );

        passportRepository.delete(passport);
    }
}
