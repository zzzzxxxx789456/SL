package com.qiudaozhang.service.impl;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.RoleMapper;
import com.qiudaozhang.model.Role;
import com.qiudaozhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 深圳邱道长
 * @since 2019/10/10
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public ResponseCode delByIds(List<Integer> ids) {
        ResponseCode code = new ResponseCode();
        int row = roleMapper.delByIds(ids);
        if(row > 0) {
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("删除角色成功！");
        } else {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("删除角色失败！");
        }

        return code;
    }

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }
}
