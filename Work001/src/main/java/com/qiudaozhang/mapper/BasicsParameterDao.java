package com.qiudaozhang.mapper;

import com.qiudaozhang.model.BasicsParameter;

public interface BasicsParameterDao {
    int deleteByPrimaryKey(String id);

    int insert(BasicsParameter record);

    int insertSelective(BasicsParameter record);

    BasicsParameter selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasicsParameter record);

    int updateByPrimaryKey(BasicsParameter record);
}