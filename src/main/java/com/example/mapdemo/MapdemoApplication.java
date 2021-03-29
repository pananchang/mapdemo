package com.example.mapdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.mapdemo.mapper")
@SpringBootApplication
public class MapdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapdemoApplication.class, args);
    }

}
