package com.qiudaozhang.mapper;

import com.qiudaozhang.model.DataDictionary;

import java.util.List;

public interface DataDictionaryDao {
    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);

    List<DataDictionary> find();
}