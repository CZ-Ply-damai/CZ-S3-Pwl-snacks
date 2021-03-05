package com.yc.sn.web;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.sn.bean.Goodstype;
import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.Result;



@FeignClient("sn-user")
public interface IUserAction {

	@PostMapping("login")
	Result login(Memberinfo m);
	
	@PostMapping("stype")
	List<Goodstype> queryStype();
	
	@PostMapping("regist")
	Result regist(Memberinfo sm);
	
	@PostMapping("sendvcode2")
	String sendvcode2(String email);

}
