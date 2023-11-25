package com.example.bankproject.JDBC_template_example.controllers;

import com.example.bankproject.JDBC_template_example.records.Passport_rec;
import com.example.bankproject.JDBC_template_example.service.PassportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("PassportController_JDBC")
@RequestMapping("api/jdbc/passports")
public class PassportController {

    private final PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping()
    public List<Passport_rec> getPassports()
    {
        return passportService.getpassports();
    }

    @GetMapping("{seria}/{number}")
    public Passport_rec getPassport(@PathVariable("seria") String seria, @PathVariable("number") String number)
    {

        return passportService.getPassport(seria,number);
    }

    @PostMapping
    public void addPassport(@RequestBody Passport_rec passport_rec)
    {
        passportService.addPassport(passport_rec);
    }

    @PutMapping
    public void updatePassport(@RequestBody Passport_rec passport_rec) {

        passportService.updatePassport(passport_rec);
    }

    @DeleteMapping("{seria}/{number}")
    public void deletePassport(@PathVariable("seria") String seria, @PathVariable("number") String number)
    {
        passportService.deletePassport(seria,number);
    }
}
