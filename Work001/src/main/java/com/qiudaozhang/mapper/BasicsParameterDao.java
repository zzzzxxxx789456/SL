package com.qiudaozhang.mapper;

import com.qiudaozhang.model.BasicsParameter;

import java.util.List;

public interface BasicsParameterDao {
    int deleteByPrimaryKey(String id);

    int insert(BasicsParameter record);

    int insertSelective(BasicsParameter record);

    BasicsParameter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasicsParameter record);

    int updateByPrimaryKey(BasicsParameter record);

    List<BasicsParameter> find();

    int delByIds(List<Integer> ids);

    int delById(Long id);
}