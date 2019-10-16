package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.AuRole;

import java.util.List;

public interface RoleService {

    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);
}
