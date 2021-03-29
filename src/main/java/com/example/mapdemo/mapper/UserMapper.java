package com.example.mapdemo.mapper;

import com.example.mapdemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User sel(int id);
}
