package com.dubbo.dubbo_provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.dubbo_provider.entity.Users;
import com.dubbo.dubbo_provider.entity.UsersExample;
import com.dubbo.dubbo_provider.mapper.UsersMapper;
import com.dubbo.dubbo_provider.util.MD5Utils;
import com.dubbo.dubbo_provider.util.UsersParam;
import com.dubbo.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(interfaceClass = UsersService.class)
public class UsersServiceImpl implements UsersService {
    @Autowired(required = false)
    private UsersMapper usersMapper;

    @Override
    public PageInfo<Users> getUsersByPage(UsersParam usersParam) {
        PageHelper.startPage(usersParam.getPage(), usersParam.getRows());
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        //放条件
        if (usersParam.getName() != null) {
            criteria.andNameLike("%" + usersParam.getName() + "%");
        }
        if (usersParam.getTelephone() != null) {
            criteria.andTelephoneLike("%" + usersParam.getTelephone() + "%");
        }
        List<Users> list = usersMapper.selectByExample(example);
        PageInfo<Users> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public Integer addUsers(Users users) {
        users.setIsadmin(0);
        //密码加密
        String password = MD5Utils.md5Encrypt(users.getPassword());
        users.setPassword(password);
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users getUsersById(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer upUsers(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users);
    }

    @Override
    public Integer deleteUsers(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteMoreUsers(Integer[] arr) {
        return usersMapper.deleteMoreUsers(arr);
    }

    //按条件查询
    @Override
    public int getUsersByName(String name) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(0);

        List<Users> list = usersMapper.selectByExample(example);
        return list.size();
    }

    //登录
    @Override
    public Users getUsersByUsers(Users users) {
        //加密
        String password = MD5Utils.md5Encrypt(users.getPassword());
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(users.getName());
        criteria.andPasswordEqualTo(password);
        criteria.andIsadminEqualTo(0);

        List<Users> list = usersMapper.selectByExample(example);
        //判断
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }
}