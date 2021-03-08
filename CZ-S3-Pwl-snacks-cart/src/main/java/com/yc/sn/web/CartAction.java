package com.yc.sn.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sn.bean.Cartinfo;
import com.yc.sn.bean.CartinfoExample;
import com.yc.sn.bean.Goodsinfo;
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
	
	@PostMapping("delC")
	public Result delC(@RequestBody Cartinfo cart) {
		CartinfoExample example = new CartinfoExample();
		example.createCriteria().andMnoEqualTo(cart.getMno()).andGnoEqualTo(cart.getGno());
		if (cim.deleteByExample(example)==1) {
			return Result.success("删除成功", null);
		}
		return Result.failure("删除失败,请联系工作人员", null);
	}
	
	@PostMapping("addInfo")
	public void addInfo(@RequestBody Orderinfo order) {
		List<Goodsinfo> list = new ArrayList<>();
		Cartinfo cart = new Cartinfo();
		for(Orderiteminfo item : order.getDetails()) {
			System.err.println(item.getGno()+"==="+item.getNums());
		}
	}
}
