
package com.yc.sn.web;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.sn.bean.BizException;
import com.yc.sn.bean.Cartinfo;
import com.yc.sn.bean.Goodsinfo;
import com.yc.sn.bean.Goodstype;
import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.Orderinfo;
import com.yc.sn.bean.Result;
import com.yc.sn.bean.Utils;



@RestController
public class IndexAction {

	@Resource
	private IUserAction iua;
	
	@Resource 
	private IGoodsAction iga;
	
	@Resource
	private ICartAction ica;
	
	@RequestMapping("login")
	public Result login(Memberinfo m,HttpSession session,
			HttpServletResponse response,HttpServletRequest request) {
		Result ret = iua.login(m);
		if (ret.getCode() == 1) {
			session.setAttribute("loginedUser", ret.getData());
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
	
	@RequestMapping("getName")
	public Result getLoginUser(HttpSession session) {
		return Result.success("会话中的用户对象", session.getAttribute("loginedUser"));
	}
	
	@RequestMapping("stype")
	public List<Goodstype> queryStype(){
		return iga.queryStype();
	}
	
	@RequestMapping("querygoods")
	public Map<String, Object> queryGoods(Integer pageIndex,String gname,Integer tno,BigDecimal num1,
			BigDecimal num2){
		Goodsinfo good = new Goodsinfo();
		good.setPage(pageIndex);
		good.setGname(gname);
		good.setTno(tno);	
		good.setNum1(num1);
		good.setNum2(num2);
		
		return iga.queryGoods(good);
	}


	@RequestMapping("regist")
   	public Result regist(Memberinfo sm,String vcode,String conpwd,HttpSession session) throws BizException {
		Result ret;
		Utils.checkNull(conpwd, "确认密码不能为空");
		Utils.checkNull(vcode, "验证码不能为空");
		if (vcode.equals(session.getAttribute(vcode))) {
			ret=iua.regist(sm);
		}else {
			throw new BizException("验证码错误");
		}    	
		return ret;
   	}
	

	@RequestMapping("good.s")
	public Goodsinfo queryGoodsById(Integer gno){
		return iga.queryGoodsById(gno);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("cart")
	public List<Cartinfo> queryCart(HttpSession session){
		System.out.println(session.getAttribute("loginedUser"));
		Map<String, Object> map = new LinkedHashMap<>();
		map = (Map<String, Object>) session.getAttribute("loginedUser");
		Integer mno = (Integer) map.get("mno");
		return ica.queryCart(mno);
	}
	
	@RequestMapping("addCart")
	public Result addCart(Integer gno,Integer nums,@SessionAttribute Memberinfo loginedUser) {
		System.out.println("11111");
		System.out.println(loginedUser);
		Cartinfo cart = new Cartinfo();
		cart.setGno(gno);
		cart.setMno(loginedUser.getMno());
		cart.setNum(nums);
		System.out.println(cart.getMno()+"==="+cart.getGno());
		return ica.addC(cart);
	}
	
	@RequestMapping("addOrd")
	public void addOrd(Orderinfo order) {
		ica.addInfo(order);

	}
	
	@RequestMapping("sendvcode2")
	public void sendvcode2(String email,HttpSession session) {
		String vcode=iua.sendvcode2(email);
		session.setAttribute("vcode", vcode);
	}
}

