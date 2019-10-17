package com.qiudaozhang.service.impl;

import com.qiudaozhang.mapper.DataDictionaryMapper;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 深圳邱道长
 * @since 2019/10/7
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {


    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> findByTypeCode(String cardType) {
        return dataDictionaryMapper.findByTypeCode(cardType);
    }
}
