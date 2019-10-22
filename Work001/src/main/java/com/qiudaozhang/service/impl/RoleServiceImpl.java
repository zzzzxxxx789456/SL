package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.RoleDao;
import com.qiudaozhang.model.Role;
import com.qiudaozhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public ResponseCode find(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> l = roleDao.find();
        PageInfo<Role> p = new PageInfo<>(l);
        ResponseCode code = new ResponseCode();
        code.setData(l);
        code.setCount(p.getTotal());
        code.setCode(0);
        return code;
    }

    @Override
    public List<Role> findAll() {
        return roleDao.find();
    }

    @Override
    public ResponseCode delById(Long id) {
        ResponseCode code = new ResponseCode();
        if (id == null) {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("非法ID");
            return code;
        }
        int row = roleDao.delById(id);
        if (row == 1) {
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("删除成功");
        } else {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("未知ID");
        }
        return code;
    }

    @Override
    public ResponseCode delGroup(List<Integer> ids) {
        ResponseCode code = new ResponseCode();
        int row = roleDao.delByIds(ids);
        if (row > 0) {
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("批量删除成功");
        } else {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("批量删除失败");
        }
        return code;
    }
}
