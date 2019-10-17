package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.GoodsPackDao;
import com.qiudaozhang.model.GoodsPack;
import com.qiudaozhang.service.GoodsPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsPackServiceImpl implements GoodsPackService {
    @Autowired
    private GoodsPackDao goodsPackDao;

    @Override
    public ResponseCode find(Integer pageSize, Integer pageNum, String goodsPickName) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsPack> l = goodsPackDao.findByGoodsPickNameLike(goodsPickName);
        PageInfo<GoodsPack> p = new PageInfo<>(l);
        ResponseCode code = new ResponseCode();
        code.setData(l);
        code.setCount(p.getTotal());
        code.setCode(0);
        return code;
    }


}
