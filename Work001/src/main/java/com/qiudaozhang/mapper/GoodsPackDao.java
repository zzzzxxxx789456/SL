package com.qiudaozhang.mapper;

import com.qiudaozhang.model.GoodsPack;

import java.util.List;

public interface GoodsPackDao {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsPack record);

    int insertSelective(GoodsPack record);

    GoodsPack selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsPack record);

    int updateByPrimaryKeyWithBLOBs(GoodsPack record);

    int updateByPrimaryKey(GoodsPack record);

    List<GoodsPack> findByGoodsPickNameLike(String goodsPickName);
}