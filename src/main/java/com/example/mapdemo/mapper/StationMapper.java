package com.example.mapdemo.mapper;

import com.example.mapdemo.entity.Station;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationMapper {
    /**
     * 根据
     * @param scheduleName
     * @return
     */
    List<Station> getStationByScheduleName(@Param("scheduleName") String scheduleName);

    /**
     * 根据id更新新的经纬度
    * @param station 电站po
     */
    void updateLng(@Param("station") Station station);

    void batchUpdateLng(@Param("stations") List<Station> stations);
}
