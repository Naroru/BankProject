package com.example.bankproject.JDBC_template_example.dao;

import com.example.bankproject.JDBC_template_example.mappers.UserMapper;
import com.example.bankproject.JDBC_template_example.records.User_rec;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;

    public UserDAO(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    public List<User_rec> getUsers()
    {
        String sql = "SELECT * FROM Users";
        return jdbcTemplate.query(sql,userMapper);
    }

    public Optional<User_rec> getUser(int id)
    {
        String sql = "SELECT * FROM Users WHERE id = ?";
        return jdbcTemplate.query(sql,userMapper,id)
                .stream()
                .findFirst();
    }
}
