package com.example.mapdemo.entity;

public class User {
    private Integer id;
    private String userName;
    private String passWOrd;
    private String realName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWOrd() {
        return passWOrd;
    }

    public void setPassWOrd(String passWOrd) {
        this.passWOrd = passWOrd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWOrd='" + passWOrd + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
