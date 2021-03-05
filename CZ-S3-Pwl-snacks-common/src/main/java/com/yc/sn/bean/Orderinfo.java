package com.yc.sn.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Orderinfo implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
    private Integer ono;

    private Date odate;

    private Integer ano;

    private Integer status;

    private BigDecimal price;

    private Integer mno;

    private List<Orderiteminfo> details;
   
	public List<Orderiteminfo> getDetails() {
		return details;
	}

	public void setDetails(List<Orderiteminfo> details) {
		this.details = details;
	}

	public Integer getOno() {
        return ono;
    }

    public void setOno(Integer ono) {
        this.ono = ono;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getMno() {
        return mno;
    }

    public void setMno(Integer mno) {
        this.mno = mno;
    }
}