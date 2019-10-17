package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;
<<<<<<< HEAD
=======
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
>>>>>>> eeb22ab88d9feca0ab5a362543275ef7195efc8c

import java.util.List;

public interface RoleService {

<<<<<<< HEAD
    ResponseCode find(Integer pageSize, Integer pageNum);
=======
    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);
>>>>>>> d8845d41c6bee535fd8247fe5e63c15bfd66d861
>>>>>>> eeb22ab88d9feca0ab5a362543275ef7195efc8c
}
