package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;

import java.util.List;

public interface BasicDataService {
    ResponseCode find(Integer pageSize, Integer pageNum);

    ResponseCode delById(Long id);

    ResponseCode delGroup(List<Integer> ids);
}
