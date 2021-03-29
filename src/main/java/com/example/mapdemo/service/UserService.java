package com.example.mapdemo.service;

import com.example.mapdemo.entity.User;
import com.example.mapdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User sel(int id){
        return userMapper.sel(id);
    }
}
