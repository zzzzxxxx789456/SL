package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.GoodsInfo;
import com.qiudaozhang.model.User;

import java.util.List;

public interface GoodsService {
    ResponseCode find(Integer pageSize, Integer pageNum, String goodsName);

    ResponseCode delById(Long id);

    ResponseCode delGroup(List<Integer> ids);

    void add(User user, GoodsInfo goodsInfo);

    ResponseCode findByState(Integer pageSize, Integer pageNum, String goodsName);
}
