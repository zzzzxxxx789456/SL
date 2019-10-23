package com.qiudaozhang.mapper;

import com.qiudaozhang.model.User;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findByLoginCodeLike(String loginCode);

    int delByIds(List<Integer> ids);

    int delById(Long id);

    User findDetailByLoginCode(String loginCode);

    void updateLoginTime(@Param("id")Long id, @Param("now")LocalDateTime now);
}