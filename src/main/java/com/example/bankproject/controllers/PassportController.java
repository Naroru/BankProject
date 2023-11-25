package com.example.bankproject.controllers;

import com.example.bankproject.entities.Passport;
import com.example.bankproject.services.PassportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/passports")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping("{id}")
    public Passport getPassport(@PathVariable int id) {

        return  passportService.getPassport(id);
    }

    @PostMapping
    public void addPassport(@RequestBody Passport passport)
    {
        passportService.savePassport(passport);
    }

    @PutMapping
    public void updatePassport(@RequestBody Passport passport)
    {
        passportService.savePassport(passport);

    }

    @DeleteMapping("{id}")
    public void deletePassport(@PathVariable int id)
    {
        passportService.deletePassport(id);
    }
}
