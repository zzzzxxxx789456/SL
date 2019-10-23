package com.qiudaozhang.service;


import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);

    void add(User user);

    ResponseCode delGroup(List<Integer> ids);

    ResponseCode delById(Long id);

    User findByLoginCode(String loginCode);

    void updateLoginTime(Long id, LocalDateTime now);
}
