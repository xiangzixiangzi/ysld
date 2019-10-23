package com.entity;

import org.springframework.format.annotation.DateTimeFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.util.Date;

public class Demo implements Serializable {
    private Integer did;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtime;

    //加方法
    public  String getDtimes(){
        String ds ="";
        if (dtime!=null){
           SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
           ds =sf.format(dtime);
        }

        return ds;
    }


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    public Demo(Integer did, String title, Date dtime) {
        this.did = did;
        this.title = title;
        this.dtime = dtime;
    }

    public Demo() {
    }

    @Override
    public String toString() {
        return "Demo{" +
                "did=" + did +
                ", title='" + title + '\'' +
                ", dtime=" + dtime +
                '}';
    }
}