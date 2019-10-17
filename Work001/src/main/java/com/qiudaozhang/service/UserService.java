package com.qiudaozhang.service;

<<<<<<< HEAD
=======
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
>>>>>>> eeb22ab88d9feca0ab5a362543275ef7195efc8c

    User findDetailByLoginCode(String loginCode);

<<<<<<< HEAD
public interface UserService {
    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);
=======
    ResponseCode modify(User user);

    ResponseCode find(Integer pageSize, Integer pageNum);

    ResponseCode delById(Long id);

    ResponseCode delGroup(List<Integer> ids);

    void add(User user);

    void updateLoginTime(Long id, LocalDateTime now);
>>>>>>> eeb22ab88d9feca0ab5a362543275ef7195efc8c
}
