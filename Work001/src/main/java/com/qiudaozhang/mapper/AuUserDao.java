package com.qiudaozhang.mapper;

import com.qiudaozhang.model.AuUser;

import java.util.List;

public interface AuUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(AuUser record);

    int insertSelective(AuUser record);

    AuUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuUser record);

    int updateByPrimaryKey(AuUser record);

    List<AuUser> findByLoginCodeLike(String loginCode);
}