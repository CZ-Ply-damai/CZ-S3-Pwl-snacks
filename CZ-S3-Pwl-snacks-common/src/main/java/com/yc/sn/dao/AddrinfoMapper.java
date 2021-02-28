package com.yc.sn.dao;

import com.yc.sn.bean.Addrinfo;
import com.yc.sn.bean.AddrinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddrinfoMapper {
    long countByExample(AddrinfoExample example);

    int deleteByExample(AddrinfoExample example);

    int deleteByPrimaryKey(Integer ano);

    int insert(Addrinfo record);

    int insertSelective(Addrinfo record);

    List<Addrinfo> selectByExample(AddrinfoExample example);

    Addrinfo selectByPrimaryKey(Integer ano);

    int updateByExampleSelective(@Param("record") Addrinfo record, @Param("example") AddrinfoExample example);

    int updateByExample(@Param("record") Addrinfo record, @Param("example") AddrinfoExample example);

    int updateByPrimaryKeySelective(Addrinfo record);

    int updateByPrimaryKey(Addrinfo record);
}