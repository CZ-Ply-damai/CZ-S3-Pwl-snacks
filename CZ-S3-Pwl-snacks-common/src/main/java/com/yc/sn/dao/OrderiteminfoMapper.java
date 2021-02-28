package com.yc.sn.dao;

import com.yc.sn.bean.Orderiteminfo;
import com.yc.sn.bean.OrderiteminfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderiteminfoMapper {
    long countByExample(OrderiteminfoExample example);

    int deleteByExample(OrderiteminfoExample example);

    int deleteByPrimaryKey(Integer ino);

    int insert(Orderiteminfo record);

    int insertSelective(Orderiteminfo record);

    List<Orderiteminfo> selectByExample(OrderiteminfoExample example);

    Orderiteminfo selectByPrimaryKey(Integer ino);

    int updateByExampleSelective(@Param("record") Orderiteminfo record, @Param("example") OrderiteminfoExample example);

    int updateByExample(@Param("record") Orderiteminfo record, @Param("example") OrderiteminfoExample example);

    int updateByPrimaryKeySelective(Orderiteminfo record);

    int updateByPrimaryKey(Orderiteminfo record);
}