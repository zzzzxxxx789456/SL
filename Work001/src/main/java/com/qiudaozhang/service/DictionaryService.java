package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;

public interface DictionaryService {

    ResponseCode find(Integer pageSize, Integer pageNum);
}
