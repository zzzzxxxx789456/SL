package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.AuUserDao;
import com.qiudaozhang.model.AuUser;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private AuUserDao userDao;

    @Override
    public ResponseCode find(Integer pageSize, Integer pageNum, String loginCode) {
        PageHelper.startPage(pageNum, pageSize);
        List<AuUser> l = userDao.findByLoginCodeLike(loginCode);
        PageInfo<AuUser> p = new PageInfo<>(l);
        ResponseCode code = new ResponseCode();
        code.setData(l);
        code.setCount(p.getTotal());
        code.setCode(0);
        return code;
    }
}
