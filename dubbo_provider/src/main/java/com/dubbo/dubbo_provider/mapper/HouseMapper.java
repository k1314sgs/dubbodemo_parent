package com.dubbo.dubbo_provider.mapper;

import com.dubbo.dubbo_provider.entity.House;
import com.dubbo.dubbo_provider.entity.HouseExample;
import com.dubbo.dubbo_provider.util.HouseParam;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //按照用户id显示房子
    List<House> getHouseByUid(Integer uid);

    //依靠id查询单条记录
    House getHouse(String id);

    //查询未审核的房子
    List<House> getHouseByIspass(Integer ispass);

    //连接搜索查询
    List<House> searchHouse(HouseParam houseParam);

    //page前台的条件搜索查询
    List<House> searchPage(HouseParam houseParam);
}