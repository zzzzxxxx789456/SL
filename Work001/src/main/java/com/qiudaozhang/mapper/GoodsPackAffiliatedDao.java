package com.qiudaozhang.mapper;

import com.qiudaozhang.model.GoodsPackAffiliated;

public interface GoodsPackAffiliatedDao {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsPackAffiliated record);

    int insertSelective(GoodsPackAffiliated record);

    GoodsPackAffiliated selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsPackAffiliated record);

    int updateByPrimaryKey(GoodsPackAffiliated record);
}