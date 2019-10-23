package com.entity;

public class Introduce {
    private Integer iid;

    private Integer pid;

    private String introduces1;

    private String introduces2;

    private String introduces3;

    private String introduces4;

    private String introduces5;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIntroduces1() {
        return introduces1;
    }

    public void setIntroduces1(String introduces1) {
        this.introduces1 = introduces1 == null ? null : introduces1.trim();
    }

    public String getIntroduces2() {
        return introduces2;
    }

    public void setIntroduces2(String introduces2) {
        this.introduces2 = introduces2 == null ? null : introduces2.trim();
    }

    public String getIntroduces3() {
        return introduces3;
    }

    public void setIntroduces3(String introduces3) {
        this.introduces3 = introduces3 == null ? null : introduces3.trim();
    }

    public String getIntroduces4() {
        return introduces4;
    }

    public void setIntroduces4(String introduces4) {
        this.introduces4 = introduces4 == null ? null : introduces4.trim();
    }

    public String getIntroduces5() {
        return introduces5;
    }

    public void setIntroduces5(String introduces5) {
        this.introduces5 = introduces5 == null ? null : introduces5.trim();
    }
}