package com.yc.sn.dao;

import com.yc.sn.bean.Goodsinfo;
import com.yc.sn.bean.GoodsinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsinfoMapper {
    long countByExample(GoodsinfoExample example);

    int deleteByExample(GoodsinfoExample example);

    int deleteByPrimaryKey(Integer gno);

    int insert(Goodsinfo record);

    int insertSelective(Goodsinfo record);

    List<Goodsinfo> selectByExampleWithBLOBs(GoodsinfoExample example);

    List<Goodsinfo> selectByExample(GoodsinfoExample example);

    Goodsinfo selectByPrimaryKey(Integer gno);

    int updateByExampleSelective(@Param("record") Goodsinfo record, @Param("example") GoodsinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Goodsinfo record, @Param("example") GoodsinfoExample example);

    int updateByExample(@Param("record") Goodsinfo record, @Param("example") GoodsinfoExample example);

    int updateByPrimaryKeySelective(Goodsinfo record);

    int updateByPrimaryKeyWithBLOBs(Goodsinfo record);

    int updateByPrimaryKey(Goodsinfo record);
}