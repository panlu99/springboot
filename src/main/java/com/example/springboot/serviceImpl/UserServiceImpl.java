/**
 * FileName: UserServiceImpl
 * Author: panlu02
 * Date: 2018/7/2 下午8:49
 * Description: UserServiceImpl
 **/
package com.example.springboot.serviceImpl;

import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into boot_user(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from boot_user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {

    }
}
