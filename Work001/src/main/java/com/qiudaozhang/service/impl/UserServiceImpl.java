package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.dto.UserDto;
import com.qiudaozhang.mapper.DataDictionaryMapper;
import com.qiudaozhang.mapper.RoleMapper;
import com.qiudaozhang.mapper.UserDao;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 深圳邱道长
 * @since 2019/10/7
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void save(User user) {
        // 查询得到卡名称
        String cardTypeName = dataDictionaryMapper.findByTypCodeValueId("CARD_TYPE", Integer.parseInt(user.getCardType()));
        user.setCardTypeName(cardTypeName);
        // 查找推荐人是否合法
        User recommender = userDao.findByUserName(user.getRecommender().getUserName());
        if (recommender != null) {
            user.setPassword("123456");
            user.setPassword2("123456");
            user.setReferId(recommender.getId());
            user.setReferCode(recommender.getLoginCode());
            user.setCreateTime(LocalDateTime.now());
            userDao.insert(user);
        }
        // 记录日志
        System.out.println("当前用户无推荐人，注册失败");

    }

    @Override
    public User findByLoginCode(String loginCode) {

        return userDao.findByLoginCode(loginCode);
    }

    @Override
    public ResponseCode modifyPwd(UserDto userDto) {
        ResponseCode code = new ResponseCode();
        // 1 查询旧的密码
        User user = userDao.findByLoginCode(userDto.getLoginCode());
        if (user.getPassword().equals(userDto.getOldPwd())) {
            // 可以修改
            userDao.modifyPwd(user.getLoginCode(), userDto.getNewPwd());
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("恭喜您，密码修改成功");
        } else {
            // 不允许修改
            code.setCode(ResponseCode.FAIL);
            code.setMsg("您输入的旧密码不正确，无法修改。");
        }
        return code;
    }

    @Override
    public ResponseCode modifyPwd2(UserDto userDto) {
        ResponseCode code = new ResponseCode();
        // 1 查询旧的密码
        User user = userDao.findByLoginCode(userDto.getLoginCode());
        if (user.getPassword2().equals(userDto.getOldPwd2())) {
            // 可以修改
            userDao.modifyPwd2(user.getLoginCode(), userDto.getNewPwd2());
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("恭喜您，二级密码修改成功");
        } else {
            // 不允许修改
            code.setCode(ResponseCode.FAIL);
            code.setMsg("您输入的旧密码不正确，无法修改。");
        }
        return code;

    }

    @Override
    public User findDetailByLoginCode(String loginCode) {

        return userDao.findDetailByLoginCode(loginCode);
    }

    @Override
    public ResponseCode modify(User user) {
        String cardTypeName = dataDictionaryMapper.findByTypCodeValueId("CARD_TYPE", Integer.parseInt(user.getCardType()));
        user.setCardTypeName(cardTypeName);
        userDao.modify(user);
        return null;
    }

    @Override
    public ResponseCode find(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> l = userDao.findByLoginCodeLike();
        PageInfo<User> p = new PageInfo<>(l);
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
    public void add(User user) {
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
    public void updateLoginTime(Long id, LocalDateTime now) {
        userDao.updateLoginTime(id,now);
    }
}
