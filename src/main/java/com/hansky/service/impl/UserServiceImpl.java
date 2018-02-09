package com.hansky.service.impl;

import com.hansky.annotation.LogHandler;
import com.hansky.dao.UserMapper;
import com.hansky.demo.User;
import com.hansky.service.UserService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shanghui on 2018/1/26.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    @LogHandler
    public User findOne(int id) {
        return userMapper.findOne(id);
    }

    public void save(User user) {
        userMapper.save(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(int id) {
        userMapper.delete(id);
    }

    @Transactional
    public void saveList(List<User> list) {
        for (int i = 0; i<list.size();i++){
            if (i==3){
                throw new RuntimeException("This is throw exception");
            }
            userMapper.save(list.get(i));
        }
    }
}
