package com.qiudaozhang.mapper;

import com.qiudaozhang.model.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {

    List<DataDictionary> findByTypeCode(String card_type);

    String findByTypeCodeValueId(String care_type, int parseInt);
}