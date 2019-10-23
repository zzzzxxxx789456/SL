package com.qiudaozhang.mapper;

import com.qiudaozhang.model.GoodsInfo;

import java.util.List;

public interface GoodsInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKeyWithBLOBs(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    List<GoodsInfo> findByGoodsNameLike(String goodsName);

    int delByIds(List<Integer> ids);

    int delById(Long id);

    List<GoodsInfo> findByGoodsNameLikeAndState(String goodsName);
}