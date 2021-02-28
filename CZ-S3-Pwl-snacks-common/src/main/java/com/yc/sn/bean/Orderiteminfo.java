package com.yc.sn.bean;

import java.math.BigDecimal;

public class Orderiteminfo {
    private Integer ino;

    private Integer ono;

    private Integer gno;

    private Integer nums;

    private BigDecimal price;

    private Integer status;

    public Integer getIno() {
        return ino;
    }

    public void setIno(Integer ino) {
        this.ino = ino;
    }

    public Integer getOno() {
        return ono;
    }

    public void setOno(Integer ono) {
        this.ono = ono;
    }

    public Integer getGno() {
        return gno;
    }

    public void setGno(Integer gno) {
        this.gno = gno;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}