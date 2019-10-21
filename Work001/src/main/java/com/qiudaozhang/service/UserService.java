package com.qiudaozhang.service;


import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.AuUser;

import java.util.List;

public interface UserService {
    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);

    void add(AuUser user);

    ResponseCode delGroup(List<Integer> ids);

    ResponseCode delById(Long id);
}
