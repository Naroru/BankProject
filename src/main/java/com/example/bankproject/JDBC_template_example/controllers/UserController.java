package com.example.bankproject.JDBC_template_example.controllers;

import com.example.bankproject.JDBC_template_example.records.User_rec;
import com.example.bankproject.JDBC_template_example.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User_rec>getUsers()
    {
        return userService.getUsers();

    }

    @GetMapping("{id}")
    public User_rec getUser(@PathVariable("id") int id)
    {
        return userService.getUser(id);
    }

   /* @PutMapping
    public void  updateUser(@ResponseBody User
    {

    }*/

    public void deleteUser(int id)
    {

    }

    public void addUser(User_rec user)
    {

    }
}


