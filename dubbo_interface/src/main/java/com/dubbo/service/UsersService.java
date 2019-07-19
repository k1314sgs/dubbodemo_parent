package com.dubbo.service;

import com.dubbo.dubbo_provider.entity.Users;
import com.dubbo.dubbo_provider.util.UsersParam;
import com.github.pagehelper.PageInfo;

public interface UsersService {
    PageInfo<Users> getUsersByPage(UsersParam usersParam);

    Integer addUsers(Users users);

    Users getUsersById(Integer id);

    Integer upUsers(Users users);

    Integer deleteUsers(Integer id);

    //自定义的
    Integer deleteMoreUsers(Integer[] arr);

    //按条件查询
    int getUsersByName(String name);

    //登录
    Users getUsersByUsers(Users users);
}
