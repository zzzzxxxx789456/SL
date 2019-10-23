package com.qiudaozhang.service;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.dto.UserDto;
import com.qiudaozhang.model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 深圳邱道长
 * @since 2019/10/7
 */
public interface UserService {
    void save(User user);

    User findByLoginCode(String loginCode);

    ResponseCode modifyPwd(UserDto userDto);

    ResponseCode modifyPwd2(UserDto userDto);

    User findDetailByLoginCode(String loginCode);

    ResponseCode modify(User user);

    ResponseCode find(Integer pageSize, Integer pageNum);

    ResponseCode delById(Long id);

    ResponseCode delGroup(List<Integer> ids);

    void updateLoginTime(Long id, LocalDateTime now);
}
