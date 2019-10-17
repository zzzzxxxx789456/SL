package com.qiudaozhang.service;

import com.qiudaozhang.model.DataDictionary;

import java.util.List;

/**
 * @author 深圳邱道长
 * @since 2019/10/7
 */
public interface DataDictionaryService {
    List<DataDictionary> findByTypeCode(String cardType);
}
