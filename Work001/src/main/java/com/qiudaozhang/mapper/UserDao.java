package com.qiudaozhang.mapper;

import com.qiudaozhang.model.User;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UserDao {

    void insert(User user);

    User findByUserName(String userName);

    User findByLoginCode(String loginCode);

    void modifyPwd(@Param("loginCode") String loginCode, @Param("newPwd") String newPwd);

    void modifyPwd2(@Param("loginCode") String loginCode, @Param("newPwd2") String newPwd2);

    User findDetailByLoginCode(String loginCode);

    void modify(User user);

    List<User> find();

    List<User> findByLoginCodeLike();

    int delById(Long id);

    int delByIds(List<Integer> ids);

    void updateLoginTime(@Param("id") Long id, @Param("now") LocalDateTime now);
}