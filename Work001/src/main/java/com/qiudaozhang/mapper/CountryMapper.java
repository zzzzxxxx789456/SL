package com.qiudaozhang.mapper;

import com.qiudaozhang.model.Country;

import java.util.List;

public interface CountryMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);

    List<Country> findAll();
}