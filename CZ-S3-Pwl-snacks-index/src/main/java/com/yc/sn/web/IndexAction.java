
package com.yc.sn.web;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.yc.sn.bean.Addrinfo;
import com.yc.sn.bean.AddrinfoExample;
import com.yc.sn.bean.BizException;
import com.yc.sn.bean.Cartinfo;
import com.yc.sn.bean.Goodsinfo;
import com.yc.sn.bean.Goodstype;
import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.Orderinfo;
import com.yc.sn.bean.Orderiteminfo;
import com.yc.sn.bean.Result;
import com.yc.sn.bean.Utils;
import com.yc.sn.dao.AddrinfoMapper;



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
		Map<String, Object> map = new LinkedHashMap<>();
		map = (Map<String, Object>) session.getAttribute("loginedUser");
		Integer mno = (Integer) map.get("mno");
		return ica.queryCart(mno);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("addCart")
	public Result addCart(Integer gno,Integer nums,HttpSession session) {
		Map<String, Object> map = new LinkedHashMap<>();
		map = (Map<String, Object>) session.getAttribute("loginedUser");
		Integer mno = (Integer) map.get("mno");
		Cartinfo cart = new Cartinfo();
		cart.setGno(gno);
		cart.setMno(mno);
		cart.setNum(nums);
		return ica.addC(cart);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("delCart")
	public Result delCart(int gno,HttpSession session) {
		Map<String, Object> map = new LinkedHashMap<>();
		map = (Map<String, Object>) session.getAttribute("loginedUser");
		Integer mno = (Integer) map.get("mno");
		Cartinfo cart = new Cartinfo();
		cart.setGno(gno);
		cart.setMno(mno);
		return ica.delC(cart);
	}
	
	@RequestMapping("addOrd")
	public void addOrd(Orderinfo order,HttpSession session) {
		List<Integer> nlist = new ArrayList<>();
		List<Goodsinfo> glist = new ArrayList<>();
		for(Orderiteminfo item : order.getDetails()) {
			nlist.add(item.getNums());
			glist.add(iga.queryGoodsById(item.getGno()));
		}
		session.setAttribute("getGood", glist);
		session.setAttribute("getNum", nlist);
		ica.addInfo(order);
	}
	
	@RequestMapping("addinfo")
	public void addInfo(int gno,int nums,HttpSession session) {
		List<Integer> nlist = new ArrayList<>();
		List<Goodsinfo> glist = new ArrayList<>();
		nlist.add(nums);
		glist.add(iga.queryGoodsById(gno));
		session.setAttribute("getGood", glist);
		session.setAttribute("getNum", nlist);
	}
	
	@RequestMapping("getNums")
	public Object getNums(HttpSession session){
		return session.getAttribute("getNum");
	}
	
	@RequestMapping("getGoods")
	public Object getGoods(HttpSession session){
		return session.getAttribute("getGood");
	}
	
	@RequestMapping("sendvcode2")
	public void sendvcode2(String email,HttpSession session) {
		String vcode=iua.sendvcode2(email);
		session.setAttribute("vcode", vcode);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryAddr")
	public List<Addrinfo> queryAddr(HttpSession session){
		Map<String, Object> map = new LinkedHashMap<>();
		map = (Map<String, Object>) session.getAttribute("loginedUser");
		Integer mno = (Integer) map.get("mno");
		return iua.queryAddress(mno);
	}
	
	@RequestMapping("changeFlag")
	public Result changeFlag(int ano,int flag) {
		Addrinfo addr = new Addrinfo();
		addr.setAno(ano);
		addr.setFlag(flag);
		return iua.changeF(addr);
	}
}

