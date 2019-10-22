package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.DataDictionary;

import java.util.List;

public interface DataDictionaryService {

    ResponseCode find(Integer pageSize, Integer pageNum);

    List<DataDictionary> findByTypeCode(String user_type);

    ResponseCode delById(Long id);

    ResponseCode delGroup(List<Integer> ids);
}
