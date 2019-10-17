package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;
<<<<<<< HEAD
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
=======
import com.qiudaozhang.model.AuRole;

import java.util.List;

public interface RoleService {

    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);
>>>>>>> d8845d41c6bee535fd8247fe5e63c15bfd66d861
}
