package com.qiudaozhang.mapper;

import com.qiudaozhang.model.User;

import java.time.LocalDateTime;

public interface UserMapper {
    User findByLoginCode(String loginCode);

    void updateLoginTime(Long id, LocalDateTime now);

    User findByUserName(String userName);

    void insert(User user);
}