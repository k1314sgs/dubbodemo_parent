package com.dubbo.dubbo_provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.dubbo_provider.entity.Street;
import com.dubbo.dubbo_provider.entity.StreetExample;
import com.dubbo.dubbo_provider.mapper.StreetMapper;
import com.dubbo.dubbo_provider.util.PageUtil;
import com.dubbo.service.StreetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(interfaceClass =StreetService.class )
public class StreetServiceImpl implements StreetService {
    @Autowired(required = false)
    private StreetMapper streetMapper;

    @Override
    public Integer deleteStreetById(Integer id) {
        return streetMapper.deleteStreetById(id);
    }

    @Override
    public PageInfo<Street> getStreet(Integer id, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        StreetExample example = new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        //条件
        criteria.andDistrictIdEqualTo(id);
        List<Street> list = streetMapper.selectByExample(example);
        PageInfo<Street> info = new PageInfo<>(list);
        return info;
    }

    //动态显示街道
    @Override
    public List<Street> getStreetByDid(Integer did) {
        StreetExample example = new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        criteria.andDistrictIdEqualTo(did);

        return streetMapper.selectByExample(example);
    }
}
