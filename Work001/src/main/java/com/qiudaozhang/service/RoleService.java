package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.Role;

import java.util.List;

/**
 * @author 深圳邱道长
 * @since 2019/10/10
 */
public interface RoleService {
    List<Role> findAll();

    ResponseCode delByIds(List<Integer> ids);

    void save(Role role);
}
