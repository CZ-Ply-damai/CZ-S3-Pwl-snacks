package com.yc.sn.bean;

public class Goodstype implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
    private Integer tno;

    private String tname;

    private Integer status;

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}