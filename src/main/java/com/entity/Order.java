package com.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer oid;

    private Integer pid;

    private Integer uid;

    private Integer rid;

    private BigDecimal number;

    private BigDecimal total;

    private Date submissiontime;

    private Integer paymentstatus;

    private Integer receivingstatus;

    private Integer showstatus;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getSubmissiontime() {
        return submissiontime;
    }

    public void setSubmissiontime(Date submissiontime) {
        this.submissiontime = submissiontime;
    }

    public Integer getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(Integer paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public Integer getReceivingstatus() {
        return receivingstatus;
    }

    public void setReceivingstatus(Integer receivingstatus) {
        this.receivingstatus = receivingstatus;
    }

    public Integer getShowstatus() {
        return showstatus;
    }

    public void setShowstatus(Integer showstatus) {
        this.showstatus = showstatus;
    }
}