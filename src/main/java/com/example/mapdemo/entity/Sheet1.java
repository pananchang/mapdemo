package com.example.mapdemo.entity;

public class Sheet1 {
    //经度
    private Double lng;
    //纬度
    private Double lat;

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }


    @Override
    public String toString() {
        return "Sheet1{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
