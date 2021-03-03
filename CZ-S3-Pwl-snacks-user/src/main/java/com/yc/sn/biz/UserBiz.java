package com.yc.sn.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.MemberinfoExample;
import com.yc.sn.dao.MemberinfoMapper;
import com.yc.sn.bean.BizException;

@Service
public class UserBiz {

	@Resource
	private MemberinfoMapper mm;
	
	public Memberinfo login(Memberinfo m) throws BizException {
		if (m.getNickname()=="") {
			throw new BizException("用户名不能为空!");
		}
		if (m.getPwd()=="") {
			throw new BizException("密码不能为空!");
		}
		MemberinfoExample example = new MemberinfoExample();
		MemberinfoExample.Criteria criteria1 = example.createCriteria();
		criteria1.andNicknameEqualTo(m.getNickname()).andPwdEqualTo(m.getPwd());

		MemberinfoExample.Criteria criteria2 = example.createCriteria();
		criteria2.andTelEqualTo(m.getNickname()).andPwdEqualTo(m.getPwd());
		
		MemberinfoExample.Criteria criteria3 = example.createCriteria();
		criteria3.andEmailEqualTo(m.getNickname()).andPwdEqualTo(m.getPwd());
		
		example.or(criteria2);
		example.or(criteria3);
		List<Memberinfo> list = mm.selectByExample(example);
		if (list.isEmpty()) {
			throw new BizException("用户名或密码错误!");
		}
		return list.get(0);
		
	}
	
	@Transactional
    public void regist(Memberinfo mb) throws Exception {
    	MemberinfoExample me=new MemberinfoExample();
    	me.createCriteria().andNicknameEqualTo(mb.getNickname());
    	List<Memberinfo> list=mm.selectByExample(me);
    	if (list.isEmpty()) {
		    mm.insertSelective(mb);
		}else {
			throw new BizException("该账号已被使用！");
		}
	}
}
