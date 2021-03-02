package com.yc.sn.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.Result;



@RestController
public class IndexAction {

	@Resource
	private IUserAction iua;
	
	@RequestMapping("login")
	public Result login(Memberinfo m,HttpSession session,
			HttpServletResponse response,HttpServletRequest request) {
		Result ret = iua.login(m);
		if (ret.getCode() == 1) {
			session.setAttribute("loginedUser", ret);
		}
		if (m.getIfcheck()==1) {
			Cookie cookie = new Cookie("nickName", m.getNickname());
			cookie.setMaxAge(60*10);
			response.addCookie(cookie);
		}else {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie2 : cookies) {
				if (cookie2.getName().equals("nickName")) {
					cookie2.setValue(null);
					cookie2.setMaxAge(0);
					response.addCookie(cookie2);
				}
			}
		}
		return ret;
	}
	
	
	@RequestMapping("getCookie")
	public String showCookie(HttpServletResponse response,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if (cookie.getName().equals("nickName")) {
				//System.out.println(cookie.getValue());
				return cookie.getValue();
			}
		}
		return null;
	}
}
