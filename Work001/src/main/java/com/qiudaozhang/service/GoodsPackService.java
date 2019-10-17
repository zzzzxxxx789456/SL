package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;

import java.util.List;

public interface GoodsPackService {
    ResponseCode find(Integer pageSize, Integer pageNum, String goodsPickName);
}
