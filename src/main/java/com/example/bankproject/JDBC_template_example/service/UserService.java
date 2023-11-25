package com.example.bankproject.JDBC_template_example.service;

import com.example.bankproject.JDBC_template_example.dao.UserDAO;
import com.example.bankproject.JDBC_template_example.records.User_rec;
import com.example.bankproject.exceptions.ObjectNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService_JDBC")
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User_rec getUser(int id)
    {
        return userDAO.getUser(id)
                .orElseThrow(() -> new ObjectNotFound(String.format("User with id = %d is not founded",id)));

    }

    public List<User_rec> getUsers()
    {
        return userDAO.getUsers();
    }


}
