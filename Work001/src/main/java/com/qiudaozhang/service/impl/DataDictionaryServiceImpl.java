package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.DataDictionaryDao;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryDao dataDictionaryDao;

    @Override
    public ResponseCode find(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<DataDictionary> l = dataDictionaryDao.find();
        PageInfo<DataDictionary> p = new PageInfo<>(l);
        ResponseCode code = new ResponseCode();
        code.setData(l);
        code.setCount(p.getTotal());
        code.setCode(0);
        return code;
    }

    @Override
    public List<DataDictionary> findByTypeCode(String user_type) {
        return dataDictionaryDao.findByTypeCode(user_type);
    }

    @Override
    public ResponseCode delById(Long id) {
        ResponseCode code = new ResponseCode();
        if (id == null) {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("非法ID");
            return code;
        }
        int row = dataDictionaryDao.delById(id);
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
        int row = dataDictionaryDao.delByIds(ids);
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
