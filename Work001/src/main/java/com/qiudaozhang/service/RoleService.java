package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.Role;

import java.util.List;

public interface RoleService {

    ResponseCode find(Integer pageSize, Integer pageNum);

    List<Role> findAll();

    ResponseCode delById(Long id);

    ResponseCode delGroup(List<Integer> ids);
}
