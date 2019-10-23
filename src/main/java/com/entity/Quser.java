package com.entity;

import java.io.Serializable;

public class Quser implements Serializable{
    private Integer qid;

    private Integer rid;

    private String phone;

    private String postal;

    private String qname;

    private String sex;

    private Receiving recei;

    public Receiving getRecei() {
        return recei;
    }

    public void setRecei(Receiving recei) {
        this.recei = recei;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal == null ? null : postal.trim();
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname == null ? null : qname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }


    @Override
    public String toString() {
        return "Quser{" +
                "qid=" + qid +
                ", rid=" + rid +
                ", phone='" + phone + '\'' +
                ", postal='" + postal + '\'' +
                ", qname='" + qname + '\'' +
                ", sex='" + sex + '\'' +
                ", recei=" + recei +
                '}';
    }
}