package com.qiudaozhang.service;

<<<<<<< HEAD
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.dto.UserDto;
=======

import com.qiudaozhang.dto.ResponseCode;
>>>>>>> 7c779a0df00b4ae94779cfa512cd1a61af9cb255
import com.qiudaozhang.model.User;

import java.time.LocalDateTime;
import java.util.List;

<<<<<<< HEAD
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

=======
public interface UserService {
    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);

    void add(User user);

    ResponseCode delGroup(List<Integer> ids);

    ResponseCode delById(Long id);

    User findByLoginCode(String loginCode);

>>>>>>> 7c779a0df00b4ae94779cfa512cd1a61af9cb255
    void updateLoginTime(Long id, LocalDateTime now);
}
