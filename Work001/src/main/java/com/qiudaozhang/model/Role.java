package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * au_role
 * @author 
 */
@Getter
@Setter
public class Role implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建日期
     */
    private LocalDate createDate;

    /**
     * 是否启用（0、未启用1、启用）
     */
    private Integer isStart;

    /**
     * 创建者
     */
    private String createdBy;

    /**
     * 最新更新时间
     */
    private LocalDateTime lastUpdateTime;

    public String getLastUpdateTimeStr(){
        if(this.lastUpdateTime == null)
            return "";
        return this.lastUpdateTime.toLocalDate() + " " + (this.lastUpdateTime.toLocalTime().toString().equals("00:00") ? "00:00:00":this.lastUpdateTime.toLocalTime());
    }
}