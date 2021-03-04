package com.yc.sn.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.sn.bean.Cartinfo;
import com.yc.sn.bean.Orderinfo;

@FeignClient("sn-cart")
public interface ICartAction {

	@PostMapping("queryCart")
	public List<Cartinfo> queryCart(int mno);
	
	@PostMapping("addInfo")
	public void addInfo(Orderinfo order);
}
