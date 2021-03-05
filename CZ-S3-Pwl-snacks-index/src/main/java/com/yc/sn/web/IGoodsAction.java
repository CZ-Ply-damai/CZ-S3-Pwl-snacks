package com.yc.sn.web;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.sn.bean.Goodsinfo;
import com.yc.sn.bean.Goodstype;

@FeignClient("sn-goods")
public interface IGoodsAction {

	@PostMapping("goods")
	Map<String, Object> queryGoods(Goodsinfo good);
	
	@PostMapping("stype")
	List<Goodstype> queryStype();
	
	@PostMapping("goodsinfo")
	Goodsinfo queryGoodsById(int gno);
}
