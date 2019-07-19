package com.dubbo.dubbo_provider.mapper;

import com.dubbo.dubbo_provider.entity.Street;
import com.dubbo.dubbo_provider.entity.StreetExample;

import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);

    //按外键删除,自定义的方法
    int deleteStreetById(Integer id);

}