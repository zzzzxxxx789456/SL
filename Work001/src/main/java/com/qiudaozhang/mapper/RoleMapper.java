package com.qiudaozhang.mapper;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {


    List<Role> findAll();

    String findById(@Param("roleId") Long roleId);

    int delByIds(List<Integer> ids);

    void save(Role role);
}