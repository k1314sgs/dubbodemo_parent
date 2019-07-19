package com.dubbo.dubbo_provider.service.impl;

import com.dubbo.dubbo_provider.entity.House;
import com.dubbo.dubbo_provider.mapper.HouseMapper;
import com.dubbo.dubbo_provider.util.HouseParam;
import com.dubbo.dubbo_provider.util.PageUtil;
import com.dubbo.service.HouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;

    @Override
    public List<House> getHouseList() {
        return houseMapper.selectByExample(null);
    }

    //添加房子
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    //按照用户id查询房子
    @Override
    public PageInfo<House> getHouseByUid(Integer uid, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());

        List<House> houseList = houseMapper.getHouseByUid(uid);
        PageInfo<House> info = new PageInfo<>(houseList);
        return info;
    }

    //按照id查询房子用于修改
    @Override
    public House getHouse(String id) {
        return houseMapper.getHouse(id);
    }

    //真正修改
    @Override
    public int update(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //逻辑删除
    @Override
    public int deleteHouse(String id, Integer isdel) {
        House house = new House();
        house.setId(id);
        house.setIsdel(isdel);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //未审核房子信息
    @Override
    public PageInfo<House> getHouseByIspass(Integer ispass, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(), pageUtil.getRows());
        List<House> list = houseMapper.getHouseByIspass(ispass);

        PageInfo<House> info = new PageInfo<>(list);
        return info;
    }

    //来审核房子
    @Override
    public int housePass(Integer ispass, String id) {
        House house = new House();
        house.setIspass(ispass);
        house.setId(id);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //搜索查询
    @Override
    public PageInfo<House> searchHouse(HouseParam houseParam) {
        PageHelper.startPage(houseParam.getPage(), houseParam.getRows());
        List<House> list = houseMapper.searchHouse(houseParam);
        PageInfo<House> info = new PageInfo<>(list);
        return info;
    }

    //page前台搜索查询
    @Override
    public PageInfo<House> searchPage(HouseParam houseParam) {
        PageHelper.startPage(houseParam.getPage(), houseParam.getRows());
        List<House> list = houseMapper.searchPage(houseParam);
        PageInfo<House> info = new PageInfo<>(list);
        return info;
    }
}
