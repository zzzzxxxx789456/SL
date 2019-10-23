package com.qiudaozhang.model;

import java.io.Serializable;

/**
 * goods_pack_affiliated
 * @author 
 */
public class GoodsPackAffiliated implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 商品套餐主表ID
     */
    private Long goodsPackId;

    /**
     * 商品ID
     */
    private Long goodsInfoId;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsPackId() {
        return goodsPackId;
    }

    public void setGoodsPackId(Long goodsPackId) {
        this.goodsPackId = goodsPackId;
    }

    public Long getGoodsInfoId() {
        return goodsInfoId;
    }

    public void setGoodsInfoId(Long goodsInfoId) {
        this.goodsInfoId = goodsInfoId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GoodsPackAffiliated other = (GoodsPackAffiliated) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsPackId() == null ? other.getGoodsPackId() == null : this.getGoodsPackId().equals(other.getGoodsPackId()))
            && (this.getGoodsInfoId() == null ? other.getGoodsInfoId() == null : this.getGoodsInfoId().equals(other.getGoodsInfoId()))
            && (this.getGoodsNum() == null ? other.getGoodsNum() == null : this.getGoodsNum().equals(other.getGoodsNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsPackId() == null) ? 0 : getGoodsPackId().hashCode());
        result = prime * result + ((getGoodsInfoId() == null) ? 0 : getGoodsInfoId().hashCode());
        result = prime * result + ((getGoodsNum() == null) ? 0 : getGoodsNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsPackId=").append(goodsPackId);
        sb.append(", goodsInfoId=").append(goodsInfoId);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}