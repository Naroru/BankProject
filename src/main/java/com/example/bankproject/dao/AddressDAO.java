package com.example.bankproject.dao;

import com.example.bankproject.entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AddressDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public Address getAddress(int id) {

        return entityManager.find(Address.class, id);
    }

    @Transactional
    public Address save(Address address) {
       return entityManager.merge(address); //save/update
    };

    public void delete(int id) {

        Query query = entityManager.createQuery("delete from Address" +
                " where id=:address_id");
        query.setParameter("address_id", id);
        query.executeUpdate();

    }
}
