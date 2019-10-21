package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.AuRoleDao;
import com.qiudaozhang.model.AuRole;
import com.qiudaozhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private AuRoleDao roleDao;

    @Override
    public ResponseCode find(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<AuRole> l = roleDao.find();
        PageInfo<AuRole> p = new PageInfo<>(l);
        ResponseCode code = new ResponseCode();
        code.setData(l);
        code.setCount(p.getTotal());
        code.setCode(0);
        return code;
    }

    @Override
    public List<AuRole> findAll() {
        return roleDao.find();
    }
}
