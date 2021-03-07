package com.yc.sn.dao;

import com.yc.sn.bean.Cartinfo;
import com.yc.sn.bean.CartinfoExample;
import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CartinfoMapper {
    long countByExample(CartinfoExample example);

    int deleteByExample(CartinfoExample example);

    int deleteByPrimaryKey(Integer cno);

    int insert(Cartinfo record);

    int insertSelective(Cartinfo record);

    List<Cartinfo> selectByExample(CartinfoExample example);
    
    @Select("select * FROM cartinfo where mno = #{mno}")
    @Results(id = "rmcart",value = {@Result(column = "gno",property = "gno"),
    		@Result(column = "gno",property = "good",
    		one = @One(select = "com.yc.sn.dao.GoodsinfoMapper.selectByPrimaryKey"))})
    List<Cartinfo> selectByMno(int mno);
    
    @Select("select * from cartinfo where mno = #{mno} and gno = #{gno}")
    @ResultMap("rmcart")
    List<Cartinfo> selectByMnoAndGno(Cartinfo cart);

    Cartinfo selectByPrimaryKey(Integer cno);

    int updateByExampleSelective(@Param("record") Cartinfo record, @Param("example") CartinfoExample example);

    int updateByExample(@Param("record") Cartinfo record, @Param("example") CartinfoExample example);

    int updateByPrimaryKeySelective(Cartinfo record);

    int updateByPrimaryKey(Cartinfo record);
    
    @Update("update cartinfo set num = num + #{num} where mno = #{mno} and gno = #{gno}")
    int updateCart(Cartinfo cart);
}