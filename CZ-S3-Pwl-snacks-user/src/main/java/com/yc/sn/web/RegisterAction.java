package com.yc.sn.web;

import javax.annotation.Resource;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.Result;
import com.yc.sn.biz.UserBiz;

public class RegisterAction {
	
	@Resource
	private UserBiz ubiz;
	
	@RequestMapping("regist")
	public Result regist(@RequestBody Memberinfo mb, Errors errors) {
		
		if (errors.hasFieldErrors("phone") || errors.hasFieldErrors("name") 
				|| errors.hasFieldErrors("pwd")) {
			return Result.failure("字段验证错误！", errors.getAllErrors());
		}
		try {
			ubiz.register(mb);
			return Result.success("注册成功！", null);
		} catch (Exception e) {
			errors.rejectValue("name", "NotOne", e.getMessage());
			return Result.failure("字段验证错误", errors.getAllErrors());
		}

	}


}
