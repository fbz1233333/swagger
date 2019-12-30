package com.example.swagger.controller;

import com.example.swagger.dao.UserMapper;
import com.example.swagger.domain.User;
import io.swagger.annotations.*;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "User系列接口",description = "提供USER的接口")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("{id}")
    @ApiOperation(value = "根据用户id查找")
    public User get(@PathVariable String  id){
        return userMapper.selectByPrimaryKey(id);
    }

    @PostMapping
    @ApiOperation(value = "新增用户",tags = "tags新增用户", httpMethod = "GET")
    public void add1(@RequestBody User user1){
        userMapper.insertSelective(user1);
    }

    @PutMapping
    @ApiOperation(value = "修改用户")
    public void update(@RequestBody User user){
        userMapper.updateByPrimaryKeySelective(user);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据用户id删除")
    public void delete(@PathVariable String id){
        userMapper.deleteByPrimaryKey(id);
    }

    //登录查询

}
