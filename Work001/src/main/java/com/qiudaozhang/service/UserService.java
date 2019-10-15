package com.qiudaozhang.service;

<<<<<<< HEAD
import com.qiudaozhang.model.User;

import java.time.LocalDateTime;

public interface UserService {
    User findByLoginCode(String loginCode);

    void updateLoginTime(Long id, LocalDateTime now);

    void save(User user);
=======

import com.qiudaozhang.dto.ResponseCode;

public interface UserService {
    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);
>>>>>>> 24a242b904e43e687c4754367365e7f319f72894
}
