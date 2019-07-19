package com.dubbo.dubbo_provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.dubbo_provider.entity.District;
import com.dubbo.dubbo_provider.entity.DistrictExample;
import com.dubbo.dubbo_provider.mapper.DistrictMapper;
import com.dubbo.dubbo_provider.mapper.StreetMapper;
import com.dubbo.dubbo_provider.util.PageUtil;
import com.dubbo.service.DistrictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass =DistrictService.class )
@Component
public class DistrictServiceImpl implements DistrictService {
    @Autowired(required = false)
    private DistrictMapper districtMapper;
    @Autowired(required = false)
    private StreetMapper streetMapper;

    public PageInfo<District> getDistrictByPage(PageUtil pageUtil) {
        //分页
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        //条件
        DistrictExample districtExample = new DistrictExample();

        List<District> districtList = districtMapper.selectByExample(districtExample);
        PageInfo<District> info = new PageInfo<>(districtList);
        return info;
    }

    //添加
    @Override
    public Integer addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    //主键查询
    @Override
    public District getDistrictById(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    //修改
    @Override
    public Integer upDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    //单条删除
    @Override
   // @Transactional//加上这个就是事务，同时提交或者同时失败
    public Integer deleteDistrict(Integer id) {
        streetMapper.deleteStreetById(id);
        districtMapper.deleteByPrimaryKey(id);
        return 1;
    }

    //批量删除
    @Override
    public Integer deleteMoreDistrict(Integer[] arr) {

        return districtMapper.deleteMoreDistrict(arr);
    }

    //全部区域

    @Override
    public List<District> getDistrictList() {
        return districtMapper.selectByExample(null);
    }
}
