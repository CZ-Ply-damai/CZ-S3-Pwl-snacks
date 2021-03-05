package com.yc.sn.biz;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.MemberinfoExample;
import com.yc.sn.bean.Utils;
import com.yc.sn.dao.MemberinfoMapper;

import com.yc.sn.bean.BizException;

@Service
public class UserBiz {

	@Resource
	private MemberinfoMapper mm;
	
	@Resource
	private MailBiz mbiz;
	
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
	
	public void reg(Memberinfo minfo) 
			throws BizException, SQLException {
		// 字段验证
		Utils.checkNull(minfo.getNickname(), "用户名不能为空");
		Utils.checkNull(minfo.getPwd(), "密码不能为空");

		Utils.checkNull(minfo.getEmail(), "邮箱不能为空");
		Utils.checkNull(minfo.getTel(), "电话号码不能为空");
		
//		// 同名验证
//		Memberinfo minfo2= udao.selectByemtel(minfo.getEmail(),minfo.getTel());
//		if(minfo2 != null ) {
//			throw new BizException("该邮箱或手机号已经被注册");
//		}
		
		jianchaName(minfo.getNickname());
		jianchaTel(minfo.getTel());
		

		mm.insert(minfo);

	}
	
	//注册时发送验证码
		
		
		//检查用户名是否有重复值
		public void jianchaName(String name) throws BizException {
			Memberinfo m =getName(name);
			if (m!=null) {
				throw new BizException("该用户名已被使用,请重新输入");
			}
		}
		
		
		//检查电话是否有重复值
			public void jianchaTel(String name) throws BizException {
				Memberinfo m = getName(name);
				if (m!=null) {
					throw new BizException("该电话已被使用,请重新输入");
				}
			}
			
			public Memberinfo selectByEmail(String email) {
				String sql = "select * from memberinfo where email = ?";
				MemberinfoExample example=new MemberinfoExample();
				example.createCriteria().andEmailEqualTo(email);
				List<Memberinfo> list=mm.selectByExample(example);
				if (list.isEmpty()) {
					return null;
				}else {
					return list.get(0);
				}
			}
			
			public Memberinfo getName(String name){
				String sql = "select * from memberinfo where nickName = ? or tel = ? or email = ?";
				MemberinfoExample example =new MemberinfoExample();
				example.createCriteria().andNicknameEqualTo(name);
				List<Memberinfo> list=mm.selectByExample(example);
				if (list.isEmpty()) {
					return null;
				}else {
					return list.get(0);
				}
				   
			}
}
