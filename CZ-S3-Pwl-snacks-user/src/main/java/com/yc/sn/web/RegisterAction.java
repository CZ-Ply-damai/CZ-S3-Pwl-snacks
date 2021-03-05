package com.yc.sn.web;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.yc.sn.biz.MailBiz;
import com.yc.sn.biz.UserBiz;
import com.yc.sn.dao.MemberinfoMapper;


public class RegisterAction {
	
	@Resource
	private UserBiz ubiz;
	
	@Resource
	private MailBiz mbiz;
	
	@Resource
	private MemberinfoMapper mm;
	
	@PostMapping("regist")
	public Result regist(Memberinfo minfo) throws SQLException {
		
		try {

			ubiz.reg(minfo);
			return Result.success("注册成功",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0,null,e.getMessage());
		} 

	}
	
	@PostMapping("sendvcode2")
	public String sendVcode(String email) throws BizException {
		//生产随机验证码
		System.out.println(email);
		String vcode = "" + System.currentTimeMillis();
		vcode = vcode.substring(vcode.length()-6);
		String reg = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(email);
		if (email.equals("")) {
			throw new BizException("邮箱不能为空");	
		}else {
			if(!m.matches()){
				throw new BizException("邮箱格式不正确");
			}			
			//根据用户获取用户信息
			Memberinfo m1 = ubiz.selectByEmail(email);
			if (m1!=null) {
				throw new BizException("该邮箱已绑定账户");
			}
			//发送邮件
			mbiz.sendSimpleMail(email, 
					"注册验证:", "请使用"+vcode+"验证码来验证");
			return vcode;
		}
	}
	
	
	


}
