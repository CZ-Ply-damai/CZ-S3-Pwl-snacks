package com.yc.sn.web;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.sn.bean.BizException;
import com.yc.sn.bean.Goodstype;
import com.yc.sn.bean.GoodstypeExample;
import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.MemberinfoExample;
import com.yc.sn.bean.Result;
import com.yc.sn.biz.UserBiz;
import com.yc.sn.dao.MemberinfoMapper;


public class RegisterAction {
	
	@Resource
	private UserBiz ubiz;
	
	@Resource
	private MemberinfoMapper mm;
	
	@PostMapping("regist")
	public Result regist(Memberinfo minfo,String vcode,String conpwd,HttpSession session) throws SQLException {
		
		try {

			ubiz.reg(minfo,conpwd,vcode,(String) session.getAttribute("vcode"));
			return Result.success("注册成功",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0,null,e.getMessage());
		} 

	}
	
	
	


}
