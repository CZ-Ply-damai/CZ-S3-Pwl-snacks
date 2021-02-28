package com.yc.sn.dao;

import com.yc.sn.bean.Admininfo;
import com.yc.sn.bean.AdmininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmininfoMapper {
    long countByExample(AdmininfoExample example);

    int deleteByExample(AdmininfoExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Admininfo record);

    int insertSelective(Admininfo record);

    List<Admininfo> selectByExample(AdmininfoExample example);

    Admininfo selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByExample(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByPrimaryKeySelective(Admininfo record);

    int updateByPrimaryKey(Admininfo record);
}