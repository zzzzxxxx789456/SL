package com.qiudaozhang.service;

<<<<<<< HEAD
=======

>>>>>>> 57300b52d2782f251b8a82dca3984dc13a8d3f61
import com.qiudaozhang.dto.ResponseCode;
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
=======
public interface UserService {
    ResponseCode find(Integer pageSize, Integer pageNum, String loginCode);
>>>>>>> 57300b52d2782f251b8a82dca3984dc13a8d3f61

    void add(User user);

    ResponseCode delGroup(List<Integer> ids);

<<<<<<< HEAD
    void updateLoginTime(Long id, LocalDateTime now);
=======
    ResponseCode delById(Long id);
<<<<<<< HEAD

    User findByLoginCode(String loginCode);

    void updateLoginTime(Long id, LocalDateTime now);
=======
>>>>>>> 57300b52d2782f251b8a82dca3984dc13a8d3f61
>>>>>>> 12b5e25d11705053545180a7c98b50a8fc7a232b
}
