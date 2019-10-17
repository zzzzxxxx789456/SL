package com.qiudaozhang.service;


import com.qiudaozhang.dto.ResponseCode;

public interface UserService {
    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);
}
