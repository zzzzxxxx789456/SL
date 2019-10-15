package com.qiudaozhang.service.impl;

import com.qiudaozhang.mapper.DataDictionaryMapper;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;
    @Override
    public List<DataDictionary> findByTypeCode(String card_type) {
        return dataDictionaryMapper.findByTypeCode(card_type);
    }
}
