package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * goods_info
 * @author 
 */
@Getter
@Setter
public class GoodsInfo implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商品编码
     */
    private String goodsSn;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 市场价
     */
    private Double marketPrice;

    /**
     * 优惠价格
     */
    private Double realPrice;

    /**
     * 状态（1、上架、2、下架）
     */
    private Integer state;

    /**
     * 库存数量
     */
    private Integer num;

    /**
     * 单位
     */
    private String unit;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 创建人
     */
    private String createdBy;

    public String getLastUpdateTimeStr(){
        if(this.lastUpdateTime == null)
            return "";
        return this.lastUpdateTime.toLocalDate() + " " + (this.lastUpdateTime.toLocalTime().toString().equals("00:00") ? "00:00:00":this.lastUpdateTime.toLocalTime());
    }
}