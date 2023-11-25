package com.example.bankproject.JDBC_template_example.service;

import com.example.bankproject.JDBC_template_example.dao.PassportDAO;
import com.example.bankproject.JDBC_template_example.records.Passport_rec;
import com.example.bankproject.exceptions.ObjectNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PassportService_JDBC")
public class PassportService {

    private final PassportDAO passportDAO;

    public PassportService(PassportDAO passportDAO) {
        this.passportDAO = passportDAO;
    }


    public Passport_rec getPassport(String series, String number) {
        return passportDAO.getPassport(series, number)
                .orElseThrow(() -> new ObjectNotFound("Passport not found"));
    }

    public List<Passport_rec> getpassports() {

        return passportDAO.getPassports();

    }

    public void addPassport(Passport_rec passport_rec) {

        int result = passportDAO.addPassport(passport_rec);

        if(result != 1)
            throw new IllegalArgumentException("passport wasn't added. Something went wrong");

    }

    public void updatePassport(Passport_rec newPassport) {

        Optional<Passport_rec> current = passportDAO.getPassport(newPassport.series(), newPassport.number());

        current.ifPresentOrElse(
                passport_rec ->
                {
                    int result = passportDAO.updatePassport(newPassport);
                    if ((result != 1))
                        throw new IllegalArgumentException("Passport wasn't updated. Smthg went wrong");

                }, () -> {

                    throw new ObjectNotFound(String.format("Passport with series %s and number %s wasn't found",
                            newPassport.series(), newPassport.number()));
                });
    }


    public void deletePassport(String seria, String number) {

        Optional<Passport_rec> current = passportDAO.getPassport(seria, number);

        current.ifPresentOrElse(passport_rec ->
        {
            int result = passportDAO.deletePassport(seria, number);
            if (result != 1)
                throw new ObjectNotFound(String.format("Passport seria = %s, number = %s wasn't found"
                        , seria, number));
        }, () -> {
            throw new IllegalArgumentException(String.format("Passport seria = %s, number = %s wasn't delete. Smthg went wrong",
                    seria, number));
        });
    }
}
