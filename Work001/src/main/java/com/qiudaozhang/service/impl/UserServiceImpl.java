package com.qiudaozhang.service.impl;

import com.qiudaozhang.mapper.DataDictionaryMapper;
import com.qiudaozhang.mapper.UserMapper;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    }
}
