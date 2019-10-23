package com.entity;

import java.math.BigDecimal;

public class Product {
    private Integer pid;

    private String pname;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private String l1;

    private String l2;

    private String l3;

    private String filename;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getL1() {
        return l1;
    }

    public void setL1(String l1) {
        this.l1 = l1 == null ? null : l1.trim();
    }

    public String getL2() {
        return l2;
    }

    public void setL2(String l2) {
        this.l2 = l2 == null ? null : l2.trim();
    }

    public String getL3() {
        return l3;
    }

    public void setL3(String l3) {
        this.l3 = l3 == null ? null : l3.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }
}