package com.yc.sn.bean;

public class Cartinfo implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
    private Integer cno;

    private Integer mno;

    private Integer gno;

    private Integer num;

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getMno() {
        return mno;
    }

    public void setMno(Integer mno) {
        this.mno = mno;
    }

    public Integer getGno() {
        return gno;
    }

    public void setGno(Integer gno) {
        this.gno = gno;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}