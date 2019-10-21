package com.qiudaozhang.mapper;

import com.qiudaozhang.model.Country;

import java.util.List;

public interface CountryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKeyWithBLOBs(Country record);

    int updateByPrimaryKey(Country record);

    List<Country> findAll();
}