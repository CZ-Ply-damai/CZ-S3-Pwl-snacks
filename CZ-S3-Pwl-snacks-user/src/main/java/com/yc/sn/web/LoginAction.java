package com.yc.sn.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sn.bean.Addrinfo;
import com.yc.sn.bean.AddrinfoExample;
import com.yc.sn.bean.BizException;
import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.Result;
import com.yc.sn.biz.UserBiz;
import com.yc.sn.dao.AddrinfoMapper;

@RestController
public class LoginAction {
	
	@Resource
	private UserBiz ubiz;
	
	@Resource
	private AddrinfoMapper aim;
	
	@PostMapping("login")
	public Result login(@RequestBody Memberinfo m,HttpSession session) throws BizException {
		Memberinfo m2;
		try {
			m2 = ubiz.login(m);
			session.setAttribute("loginedUser", m2);
			return Result.success("登录成功！", m2);
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure(e.getMessage(), null);
		}
	}
	
	@PostMapping("queryAddress")
	public List<Addrinfo> queryAddress(@RequestBody int mno){
		AddrinfoExample example = new AddrinfoExample();
		example.createCriteria().andMnoEqualTo(mno);
		example.setOrderByClause("flag desc");
		return aim.selectByExample(example);
	}

}
