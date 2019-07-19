package com.dubbo.dubbo_provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.dubbo_provider.entity.Type;
import com.dubbo.dubbo_provider.entity.TypeExample;
import com.dubbo.dubbo_provider.mapper.TypeMapper;
import com.dubbo.dubbo_provider.util.PageUtil;
import com.dubbo.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(interfaceClass = TypeService.class)
public class TypeServiceImpl implements TypeService {
    @Autowired(required = false)
    private TypeMapper typeMapper;

    @Override
    public PageInfo<Type> getTypeByPage(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        TypeExample example = new TypeExample();
        List<Type> list = typeMapper.selectByExample(example);
        PageInfo<Type> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public Integer addType(Type type) {
        return typeMapper.insertSelective(type);
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer upType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public Integer deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteMoreType(Integer[] arr) {
        return typeMapper.deleteMoreType(arr);
    }

    //全部类型
    @Override
    public List<Type> getTypeList() {
        return typeMapper.selectByExample(null);
    }
}

