package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;

import java.util.List;

public interface GoodsService {
    ResponseCode find(Integer pageSize, Integer pageNum, String goodsName);

    ResponseCode delById(Long id);

    ResponseCode delGroup(List<Integer> ids);
}
