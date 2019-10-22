package com.qiudaozhang.mapper;

import com.qiudaozhang.model.GoodsInfo;
import com.qiudaozhang.model.GoodsInfoWithBLOBs;

import java.util.List;

public interface GoodsInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfoWithBLOBs record);

    int insertSelective(GoodsInfoWithBLOBs record);

    GoodsInfoWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsInfoWithBLOBs record);

    int updateByPrimaryKey(GoodsInfo record);

    List<GoodsInfo> findByGoodsNameLike(String goodsName);

    int delByIds(List<Integer> ids);

    int delById(Long id);
}