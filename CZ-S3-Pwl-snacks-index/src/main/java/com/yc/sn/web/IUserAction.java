package com.yc.sn.web;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.Result;



@FeignClient("sn-user")
public interface IUserAction {

	@PostMapping("login")
	Result login(Memberinfo m);
	
	@PostMapping("register")
	Result register(Memberinfo m);
}
