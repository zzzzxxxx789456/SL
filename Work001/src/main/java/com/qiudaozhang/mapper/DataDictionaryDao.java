package com.qiudaozhang.mapper;

import com.qiudaozhang.model.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDictionaryDao {
    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);

    List<DataDictionary> find();

    List<DataDictionary> findByTypeCode(@Param("cardType") String user_type);

    String findByTypCodeValueId(@Param("cardType") String cardType, @Param("valueId") Integer valueId);
}