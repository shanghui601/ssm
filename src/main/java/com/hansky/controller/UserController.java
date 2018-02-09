package com.hansky.controller;

import com.alibaba.fastjson.JSONObject;
import com.hansky.demo.User;
import com.hansky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shanghui on 2018/1/31.
 * 新分支
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<User> findAll(){
        System.out.println("findAll");
        List<User> userList = userService.findAll();
        return userList;
    }

    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public User findOne(String id){
        System.out.println("findOne");
        User user = userService.findOne(Integer.getInteger(id));
        return user;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,consumes = "application/json")
    public void save(@RequestBody JSONObject jsonObject){
        System.out.println("save");
        System.out.println(jsonObject);
        User user = jsonObject.toJavaObject(User.class);
        userService.save(user);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT,consumes = "application/json")
    public void update(@PathVariable("id")int id, @RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        User user = jsonObject.toJavaObject(User.class);
        user.setId(id);
        userService.update(user);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")int id){
        System.out.println("delete");
        userService.delete(id);
    }


}
