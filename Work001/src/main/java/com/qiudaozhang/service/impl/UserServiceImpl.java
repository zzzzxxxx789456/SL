package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.AuRoleDao;
import com.qiudaozhang.mapper.AuUserDao;
import com.qiudaozhang.mapper.DataDictionaryDao;
import com.qiudaozhang.model.AuUser;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private AuUserDao userDao;

    @Autowired
    private DataDictionaryDao dataDictionaryMapper;

    @Autowired
    private AuRoleDao roleMapper;

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

    @Override
    public void add(AuUser user) {
        // todo
        // 处理得到角色ID和角色名称
        //
        String roleName = roleMapper.findById(user.getRoleId());
        user.setRoleName(roleName);
        if(user.getRoleId() != 1){
            // 处理会员类型
            String userTypeName = dataDictionaryMapper.findByTypCodeValueId("USER_TYPE", Integer.parseInt(user.getUserType()));
            user.setUserTypeName(userTypeName);
        } else {
            user.setUserType(null);
            user.setUserTypeName(null);
        }

        // 处理证件
        String cardTypeName = dataDictionaryMapper.findByTypCodeValueId("CARD_TYPE", Integer.parseInt(user.getCardType()));
        user.setCardTypeName(cardTypeName);
        // 处理推荐人
        user.setReferId(user.getRecommender().getId());
        user.setReferCode(user.getRecommender().getLoginCode());
        // 处理创建日期
        user.setCreateTime(LocalDateTime.now());
        user.setPassword("123456");
        user.setPassword2("123456");
        userDao.insert(user);

    }

    @Override
    public ResponseCode delGroup(List<Integer> ids) {
        ResponseCode code = new ResponseCode();
        int row = userDao.delByIds(ids);
        if (row > 0) {
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("批量删除成功");
        } else {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("批量删除失败");
        }
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
        int row = userDao.delById(id);
        if (row == 1) {
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("删除成功");
        } else {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("未知ID");
        }
        return code;
    }
}
