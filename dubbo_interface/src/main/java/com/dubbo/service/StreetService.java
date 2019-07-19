package com.dubbo.service;

import com.dubbo.dubbo_provider.entity.Street;
import com.dubbo.dubbo_provider.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StreetService {

    Integer deleteStreetById(Integer id);

    PageInfo<Street> getStreet(Integer id, PageUtil pageUtil);

    List<Street>getStreetByDid(Integer did);
}
