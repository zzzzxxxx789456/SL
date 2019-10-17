package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.GoodsInfoDao;
import com.qiudaozhang.model.GoodsInfo;
import com.qiudaozhang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsInfoDao goodsInfoDao;

    @Override
    public ResponseCode find(Integer pageSize, Integer pageNum, String goodsName) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsInfo> l = goodsInfoDao.findByGoodsNameLike(goodsName);
        PageInfo<GoodsInfo> p = new PageInfo<>(l);
        ResponseCode code = new ResponseCode();
        code.setData(l);
        code.setCount(p.getTotal());
        code.setCode(0);
        return code;
    }
}
