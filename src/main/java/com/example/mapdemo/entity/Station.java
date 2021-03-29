package com.example.mapdemo.entity;


public class Station {

  private long id;
  private String stationId;
  private String stationName;
  private String scheduleId;
  private String scheduleName;
  private double longitude;
  private double latitude;
  private double longitudeNew;
  private double latitudeNew;
  private String location;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }


  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }


  public String getScheduleId() {
    return scheduleId;
  }

  public void setScheduleId(String scheduleId) {
    this.scheduleId = scheduleId;
  }


  public String getScheduleName() {
    return scheduleName;
  }

  public void setScheduleName(String scheduleName) {
    this.scheduleName = scheduleName;
  }


  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }


  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }


  public double getLongitudeNew() {
    return longitudeNew;
  }

  public void setLongitudeNew(double longitudeNew) {
    this.longitudeNew = longitudeNew;
  }


  public double getLatitudeNew() {
    return latitudeNew;
  }

  public void setLatitudeNew(double latitudeNew) {
    this.latitudeNew = latitudeNew;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "Station{" +
            "id=" + id +
            ", stationId='" + stationId + '\'' +
            ", stationName='" + stationName + '\'' +
            ", scheduleId='" + scheduleId + '\'' +
            ", scheduleName='" + scheduleName + '\'' +
            ", longitude=" + longitude +
            ", latitude=" + latitude +
            ", longitudeNew=" + longitudeNew +
            ", latitudeNew=" + latitudeNew +
            ", location='" + location + '\'' +
            '}';
  }
}
