package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * goods_pack
 * @author 
 */
@Getter
@Setter
public class GoodsPack implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 套餐名称
     */
    private String goodsPackName;

    /**
     * 套餐编码
     */
    private String goodsPackCode;

    /**
     * 套餐类型ID
     */
    private Integer typeId;

    /**
     * 套餐类型NAME
     */
    private String typeName;

    /**
     * 套餐总价（系统生成，保存时根据相关商品的优惠价*数量计算生成）
     */
    private Double totalPrice;

    /**
     * 状态（1、上架2、下架）
     */
    private Integer state;

    /**
     * 库存数量
     */
    private Integer num;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 备注说明
     */
    private String note;

    public String getLastUpdateTimeStr(){
        if(this.lastUpdateTime == null)
            return "";
        return this.lastUpdateTime.toLocalDate() + " " + (this.lastUpdateTime.toLocalTime().toString().equals("00:00") ? "00:00:00":this.lastUpdateTime.toLocalTime());
    }
}