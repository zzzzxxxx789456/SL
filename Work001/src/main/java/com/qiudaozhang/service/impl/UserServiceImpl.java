package com.qiudaozhang.service.impl;

<<<<<<< HEAD
import com.qiudaozhang.mapper.DataDictionaryMapper;
import com.qiudaozhang.mapper.UserMapper;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.model.User;
=======
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.AuUserDao;
import com.qiudaozhang.model.AuUser;
>>>>>>> 24a242b904e43e687c4754367365e7f319f72894
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public User findByLoginCode(String loginCode) {
        return userMapper.findByLoginCode(loginCode);
    }

    @Override
    public void updateLoginTime(Long id, LocalDateTime now) {
        userMapper.updateLoginTime(id, now);
    }

    @Override
    public void save(User user) {
        String cardTypeName = dataDictionaryMapper.findByTypeCodeValueId("CARE_TYPE", Integer.parseInt(user.getCardType()));
        user.setCardTypeName(cardTypeName);
        User recommender = userMapper.findByUserName(user.getRecommender().getUserName());
        if (recommender != null) {
            user.setPassword("123456");
            user.setPassword2("123456");
            user.setReferId(recommender.getId());
            user.setReferCode(recommender.getLoginCode());
            user.setCreateTime(LocalDateTime.now());
            userMapper.insert(user);
        }
        System.out.println("当前用户无推荐人，注册失败！");
=======
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
>>>>>>> 24a242b904e43e687c4754367365e7f319f72894
    }
}
