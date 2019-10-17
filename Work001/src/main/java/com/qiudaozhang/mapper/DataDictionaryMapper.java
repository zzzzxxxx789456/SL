package com.qiudaozhang.mapper;

import com.qiudaozhang.model.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDictionaryMapper {

    List<DataDictionary> findByTypeCode(@Param("cardType") String cardType);

    String findByTypCodeValueId(@Param("cardType") String cardType, @Param("valueId") Integer valueId);
}