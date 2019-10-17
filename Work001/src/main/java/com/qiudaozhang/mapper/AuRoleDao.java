package com.qiudaozhang.mapper;

import com.qiudaozhang.model.AuRole;

import java.util.List;

public interface AuRoleDao {

    int deleteByPrimaryKey(Long id);

    int insert(AuRole record);

    int insertSelective(AuRole record);

    AuRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuRole record);

    int updateByPrimaryKey(AuRole record);

    List<AuRole> find();
}