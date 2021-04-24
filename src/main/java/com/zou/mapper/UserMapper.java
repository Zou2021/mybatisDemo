package com.zou.mapper;

import com.zou.entity.User;

import java.util.List;

/**
 * @author: 邹祥发
 * @date: 2021/4/23 20:49
 */
public interface UserMapper {

    List<User> selectList() throws Exception;

    List<User> selectlike01() throws Exception;

    List<User> selectlike02(String name) throws Exception;

    List<User> selectlike03(User user) throws Exception;

    void insert(User user) throws Exception;

    List<User> sqlSelect01(User user) throws Exception;

    List<User> sqlSelect02(User user) throws Exception;

    List<User> sqlSelect03(User user) throws Exception;

}
