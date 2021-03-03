package com.yc.sn.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sn.bean.Goodstype;
import com.yc.sn.bean.GoodstypeExample;
import com.yc.sn.dao.GoodsinfoMapper;
import com.yc.sn.dao.GoodstypeMapper;

@RestController
public class GoodsAction {

	@Resource
	private GoodsinfoMapper gim;
	
	@Resource
	private GoodstypeMapper gsm;
	
	@PostMapping("stype")
	public List<Goodstype> queryStype(){
		GoodstypeExample example = new GoodstypeExample();
		return gsm.selectByExample(example);
	}
}
