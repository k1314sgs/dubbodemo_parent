package com.dubbo.dubbo_provider.mapper;

import com.dubbo.dubbo_provider.entity.Type;
import com.dubbo.dubbo_provider.entity.TypeExample;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    int deleteMoreType(Integer[] arr);
}