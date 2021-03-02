package com.yc.sn.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.sn.bean.Goodstype;

@FeignClient("sn-goods")
public interface IStypeAction {

	@PostMapping("stype")
	List<Goodstype> queryStype();
}
