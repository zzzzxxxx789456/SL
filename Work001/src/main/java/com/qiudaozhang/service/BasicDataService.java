package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;

public interface BasicDataService {
    ResponseCode find(Integer pageSize, Integer pageNum);
}
