
package com.yc.sn.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.sn.bean.Goodsinfo;
import com.yc.sn.bean.GoodsinfoExample;
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
	
	@PostMapping("goods")
	public Map<String, Object> queryGoods(@RequestBody Goodsinfo good){
		boolean count = true;
		GoodsinfoExample example = new GoodsinfoExample();
		if (good.getGname()!="") {
			example.createCriteria().andGnameLike(good.getGname());
		}
		if (good.getTno()!=null) {
			example.createCriteria().andTnoEqualTo(good.getTno());
		}
		//example.createCriteria().andGnameLike(good.getGname()).andTnoEqualTo(good.getTno());
		Page<Goodsinfo> p = PageHelper.startPage(good.getPage(), 20,count);		
		example.setOrderByClause("gno asc");
		gim.selectByExample(example);
		Map<String, Object> ret = new HashMap<>();
		// 分页数据
		ret.put("list", p);
		// 总页数
		ret.put("pages", p.getPages());
		return ret;
	}
}

