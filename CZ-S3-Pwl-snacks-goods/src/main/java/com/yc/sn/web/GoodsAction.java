
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
			if (good.getNum1()!=null && good.getNum2()!=null) {
				example.createCriteria().andGnameLike("%"+good.getGname()+"%")
				.andPriceBetween(good.getNum1(), good.getNum2());
			}else if (good.getNum1()!=null) {
				System.out.println(good.getNum1());
				example.createCriteria().andGnameLike("%"+good.getGname()+"%")
				.andPriceGreaterThanOrEqualTo(good.getNum1());
			}else if (good.getNum2()!=null) {
				example.createCriteria().andGnameLike("%"+good.getGname()+"%")
				.andPriceGreaterThanOrEqualTo(good.getNum2());
			}
			example.createCriteria().andGnameLike("%"+good.getGname()+"%");
		}
		if (good.getTno()!=null) {
			example.createCriteria().andTnoEqualTo(good.getTno());
		}
		if (good.getNum1()!=null && good.getNum2()!=null) {
			example.createCriteria().andPriceBetween(good.getNum1(), good.getNum2());
		}else if (good.getNum1()!=null) {
			example.createCriteria().andPriceGreaterThanOrEqualTo(good.getNum1());
		}else if (good.getNum2()!=null) {
			example.createCriteria().andPriceGreaterThanOrEqualTo(good.getNum2());
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
	
	@PostMapping("goodsinfo")
	public Goodsinfo queryGoodsById(@RequestBody int gno){
		GoodsinfoExample example = new GoodsinfoExample();
		example.createCriteria().andGnoEqualTo(gno);
		
		return gim.selectByExample(example).get(0);
	}
}

