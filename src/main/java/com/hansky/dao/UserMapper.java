package com.hansky.dao;

import com.hansky.demo.User;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by shanghui on 2018/1/26.
 */
@MapperScan
public interface UserMapper {
    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(User user);

    void delete(int id);
}
