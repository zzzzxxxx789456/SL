package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.BasicsParameterDao;
import com.qiudaozhang.model.BasicsParameter;
import com.qiudaozhang.service.BasicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicDataServiceImpl implements BasicDataService {

    @Autowired
    private BasicsParameterDao basicsParameterDao;

    @Override
    public ResponseCode find(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<BasicsParameter> l = basicsParameterDao.find();
        PageInfo<BasicsParameter> p = new PageInfo<>(l);
        ResponseCode code = new ResponseCode();
        code.setData(l);
        code.setCount(p.getTotal());
        code.setCode(0);
        return code;
    }
}
