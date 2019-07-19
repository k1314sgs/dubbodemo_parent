package com.dubbo.service;

import com.dubbo.dubbo_provider.entity.House;
import com.dubbo.dubbo_provider.util.HouseParam;
import com.dubbo.dubbo_provider.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HouseService {

    List<House> getHouseList();

    int addHouse(House house);

    //按照用户查询
    PageInfo<House> getHouseByUid(Integer uid, PageUtil pageUtil);

    //按id查询单条用于修改
    House getHouse(String id);

    //修改
    int update(House house);

    //逻辑删除
    int deleteHouse(String id, Integer isdel);

    //未审核房子信息
    PageInfo<House> getHouseByIspass(Integer ispass, PageUtil pageUtil);

    //审核房子
    int housePass(Integer ispass, String id);

    //搜索查询
    PageInfo<House>searchHouse(HouseParam houseParam);

    //page前台搜索查询
    PageInfo<House>searchPage(HouseParam houseParam);
}
