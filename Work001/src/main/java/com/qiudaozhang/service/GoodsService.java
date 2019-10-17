package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;

public interface GoodsService {
    ResponseCode find(Integer pageSize, Integer pageNum, String goodsName);

}
