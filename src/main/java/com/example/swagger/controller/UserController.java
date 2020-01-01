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
    @ApiResponses({
            @ApiResponse(code = 200, message = "200:查找成功"),
            @ApiResponse(code = 401, message = "401:尚未授权"),
            @ApiResponse(code = 403, message = "403:被禁止"),
            @ApiResponse(code = 410, message = "410:特殊情况"),
            @ApiResponse(code = 404, message = "404:找不到请求")})
    public User get(@PathVariable String  id){
        return userMapper.selectByPrimaryKey(id);
    }

//    ,name = "user_Name"指的是接口信息下面的USER信息
    @PostMapping
    @ApiOperation(value = "新增用户")
    public void add1(@RequestBody @ApiParam(value = "用户信息") User user1){
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
