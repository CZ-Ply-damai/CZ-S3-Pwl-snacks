package com.yc.sn.bean;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class Memberinfo implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer ifcheck;
	
    private Integer mno;

    private String nickname;

    private String realname;

    //@NotEmpty(message = "密码不能为空！")
    private String pwd;

    private String tel;

    //@NotEmpty(message = "邮箱不能为空！")
    private String email;

    private String photo;

    private Date regdate;

    private Integer status;

    
    
    public Integer getIfcheck() {
		return ifcheck;
	}

	public void setIfcheck(Integer ifcheck) {
		this.ifcheck = ifcheck;
	}

	public Integer getMno() {
        return mno;
    }

    public void setMno(Integer mno) {
        this.mno = mno;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}