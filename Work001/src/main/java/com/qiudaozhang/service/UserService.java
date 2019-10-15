package com.qiudaozhang.service;

import com.qiudaozhang.model.User;

import java.time.LocalDateTime;

public interface UserService {
    User findByLoginCode(String loginCode);

    void updateLoginTime(Long id, LocalDateTime now);

    void save(User user);
}
