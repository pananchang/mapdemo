package com.example.mapdemo.entity;


public class MapInfo {

  private long id;
  private String scheduleId;
  private String scheudleName;
  private double longitude;
  private double latitude;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getScheduleId() {
    return scheduleId;
  }

  public void setScheduleId(String scheduleId) {
    this.scheduleId = scheduleId;
  }


  public String getScheudleName() {
    return scheudleName;
  }

  public void setScheudleName(String scheudleName) {
    this.scheudleName = scheudleName;
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

  @Override
  public String toString() {
    return "MapInfo{" +
            "id=" + id +
            ", scheduleId='" + scheduleId + '\'' +
            ", scheudleName='" + scheudleName + '\'' +
            ", longitude=" + longitude +
            ", latitude=" + latitude +
            '}';
  }
}
