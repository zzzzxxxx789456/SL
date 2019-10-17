package com.qiudaozhang.service.impl;

<<<<<<< HEAD
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.RoleMapper;
import com.qiudaozhang.model.Role;
=======
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.AuRoleDao;
import com.qiudaozhang.model.AuRole;
>>>>>>> d8845d41c6bee535fd8247fe5e63c15bfd66d861
import com.qiudaozhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

<<<<<<< HEAD
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
=======
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
>>>>>>> d8845d41c6bee535fd8247fe5e63c15bfd66d861
}
