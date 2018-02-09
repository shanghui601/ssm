package com.hansky.test;

import com.hansky.dao.UserMapper;
import com.hansky.demo.User;
import com.hansky.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shanghui on 2018/1/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-context.xml","classpath:spring/spring-mvc.xml" })
public class UserTest {


    @Autowired
    private UserService userService;

    @Test
    public void findAll(){
        List<User> all = userService.findAll();
        System.out.println(all);
    }

    @Test
    public void findOne(){
        User one = userService.findOne(2);
        System.out.println(one);
    }

    @Test
    public void save(){
        User user = new User();
        user.setAge(18);
        user.setUsername("liuhuan");
        userService.save(user);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(1);
        user.setAge(19);
        user.setUsername("liuhuan");
        userService.update(user);
    }

    @Test
    public void delete(){
        userService.delete(1);
    }

    @Test
    public void saveList(){
        List<User> list = new ArrayList<User>();
        for (int i = 0;i<10;i++){
            User user = new User();
            user.setUsername("a"+i);
            user.setAge(i);
            list.add(user);
        }

        userService.saveList(list);
    }
}
