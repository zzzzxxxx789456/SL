package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;

import java.util.List;

public interface GoodsPackService {
    ResponseCode find(Integer pageSize, Integer pageNum, String goodsPickName);

    ResponseCode delById(Long id);

    ResponseCode delGroup(List<Integer> ids);
}
