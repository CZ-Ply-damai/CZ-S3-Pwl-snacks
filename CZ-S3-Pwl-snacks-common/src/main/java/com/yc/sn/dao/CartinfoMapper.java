package com.yc.sn.dao;

import com.yc.sn.bean.Cartinfo;
import com.yc.sn.bean.CartinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartinfoMapper {
    long countByExample(CartinfoExample example);

    int deleteByExample(CartinfoExample example);

    int deleteByPrimaryKey(Integer cno);

    int insert(Cartinfo record);

    int insertSelective(Cartinfo record);

    List<Cartinfo> selectByExample(CartinfoExample example);

    Cartinfo selectByPrimaryKey(Integer cno);

    int updateByExampleSelective(@Param("record") Cartinfo record, @Param("example") CartinfoExample example);

    int updateByExample(@Param("record") Cartinfo record, @Param("example") CartinfoExample example);

    int updateByPrimaryKeySelective(Cartinfo record);

    int updateByPrimaryKey(Cartinfo record);
}