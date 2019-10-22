package com.qiudaozhang.mapper;

import com.qiudaozhang.model.Role;

import java.util.List;

public interface RoleDao {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> find();

    String findById(Long roleId);

    int delByIds(List<Integer> ids);

    int delById(Long id);
}