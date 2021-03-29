package com.example.mapdemo;

import com.example.mapdemo.service.StationService;
import com.example.mapdemo.util.mapUtil.Point;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MapdemoApplicationTests {
    @Autowired
    private StationService stationService;
    @Test
    void contextLoads() {
       /* Map<String, List<List<Point>>> mapInfo = stationService.getMapInfo();
        System.out.println(mapInfo);*/
        stationService.execute();

    }

}
