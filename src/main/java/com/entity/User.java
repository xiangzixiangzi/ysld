package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private Integer uid;

    private String uname;

    private String pwd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String telephone;

    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date logintime;

    private Integer jurisdiction;
    //验证码
    private String yanzheng;

    public String getYanzheng() {
        return yanzheng;
    }

    public void setYanzheng(String yanzheng) {
        this.yanzheng = yanzheng;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Integer getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", date=" + date +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", logintime=" + logintime +
                ", jurisdiction=" + jurisdiction +
                ", yanzheng='" + yanzheng + '\'' +
                '}';
    }
}