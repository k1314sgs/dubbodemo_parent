package com.dubbo.dubbo_provider.mapper;

import com.dubbo.dubbo_provider.entity.Users;
import com.dubbo.dubbo_provider.entity.UsersExample;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    //批量删除
    int deleteMoreUsers(Integer[] arr);
}