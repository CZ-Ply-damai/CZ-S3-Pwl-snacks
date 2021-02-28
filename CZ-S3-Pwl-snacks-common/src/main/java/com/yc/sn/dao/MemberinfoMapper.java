package com.yc.sn.dao;

import com.yc.sn.bean.Memberinfo;
import com.yc.sn.bean.MemberinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberinfoMapper {
    long countByExample(MemberinfoExample example);

    int deleteByExample(MemberinfoExample example);

    int deleteByPrimaryKey(Integer mno);

    int insert(Memberinfo record);

    int insertSelective(Memberinfo record);

    List<Memberinfo> selectByExample(MemberinfoExample example);

    Memberinfo selectByPrimaryKey(Integer mno);

    int updateByExampleSelective(@Param("record") Memberinfo record, @Param("example") MemberinfoExample example);

    int updateByExample(@Param("record") Memberinfo record, @Param("example") MemberinfoExample example);

    int updateByPrimaryKeySelective(Memberinfo record);

    int updateByPrimaryKey(Memberinfo record);
}