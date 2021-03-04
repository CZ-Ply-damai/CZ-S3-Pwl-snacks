package com.yc.sn.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yc.sn.bean.Cartinfo;
import com.yc.sn.dao.CartinfoMapper;

@RestController
public class CartAction {

	@Resource
	private CartinfoMapper cim;
	
	@PostMapping("queryCart")
	public List<Cartinfo> queryCart(@RequestBody int mno){
		return cim.selectByMno(mno);
	}
}
