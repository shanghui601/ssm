package com.hansky.service;

import com.hansky.demo.User;

import java.util.List;

/**
 * Created by shanghui on 2018/1/26.
 */
public interface UserService {
    User findOne(int id);

    void saveList(List<User> list);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(int id);
}
