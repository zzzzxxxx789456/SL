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

    @Override
    public ResponseCode delById(Long id) {
        ResponseCode code = new ResponseCode();
        if (id == null) {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("非法ID");
            return code;
        }
        int row = goodsPackDao.delById(id);
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
        int row = goodsPackDao.delByIds(ids);
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
