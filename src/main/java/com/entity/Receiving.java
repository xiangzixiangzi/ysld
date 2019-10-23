package com.entity;

import java.io.Serializable;

public class Receiving implements Serializable{
    private Integer rid;

    private Integer uid;

    private String raddress;

    private Integer adressstatus;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress == null ? null : raddress.trim();
    }

    public Integer getAdressstatus() {
        return adressstatus;
    }

    public void setAdressstatus(Integer adressstatus) {
        this.adressstatus = adressstatus;
    }
}