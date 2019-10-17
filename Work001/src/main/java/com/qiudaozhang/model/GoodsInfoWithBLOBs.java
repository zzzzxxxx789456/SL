package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * goods_info
 * @author 
 */
@Getter
@Setter
public class GoodsInfoWithBLOBs extends GoodsInfo implements Serializable {
    /**
     * 商品规格
     */
    private String goodsFormat;

    /**
     * 商品说明
     */
    private String note;


}