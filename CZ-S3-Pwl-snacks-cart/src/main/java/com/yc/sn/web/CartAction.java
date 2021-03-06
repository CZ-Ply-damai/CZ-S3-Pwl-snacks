package com.yc.sn.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sn.bean.Cartinfo;
import com.yc.sn.bean.CartinfoExample;
import com.yc.sn.bean.Orderinfo;
import com.yc.sn.bean.Orderiteminfo;
import com.yc.sn.bean.Result;
import com.yc.sn.dao.CartinfoMapper;

@RestController
public class CartAction {

	@Resource
	private CartinfoMapper cim;
	
	@PostMapping("queryCart")
	public List<Cartinfo> queryCart(@RequestBody int mno){
		return cim.selectByMno(mno);
	}
	
	@PostMapping("addC")
	public Result addC(@RequestBody Cartinfo cart) {
		CartinfoExample example = new CartinfoExample();
		example.createCriteria().andMnoEqualTo(cart.getMno()).andGnoEqualTo(cart.getGno());
		int i = cim.updateCart(cart);
		if (i==0) {
			cim.insert(cart);
		}
		return Result.success("添加成功", null);
	}
	
	@PostMapping("addInfo")
	public void addInfo(@RequestBody Orderinfo order) {
		for(Orderiteminfo item : order.getDetails()) {
			System.err.println(item.getGno()+"==="+item.getNums());
		}
	}
}
