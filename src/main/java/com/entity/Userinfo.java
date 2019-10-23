package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Userinfo implements Serializable{
    private Integer usid;

    private Integer uid;

    private String nocheng;

    private String address;

    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String picture;

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNocheng() {
        return nocheng;
    }

    public void setNocheng(String nocheng) {
        this.nocheng = nocheng == null ? null : nocheng.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();

    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "usid=" + usid +
                ", uid=" + uid +
                ", nocheng='" + nocheng + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", picture='" + picture + '\'' +
                '}';
    }
}