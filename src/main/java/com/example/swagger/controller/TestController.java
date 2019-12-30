package com.example.swagger.controller;

import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "Test系列接口",description = "TEST系列接口的description")
public class TestController {


//    @ApiResponse(code = 401, message = "测试返回体")
    @ApiOperation(value = "测试TEST1",notes = "测试返回的ResponseEntity",httpMethod = "GET",response = ResponseEntity.class)
    @GetMapping("{info}")
    public ResponseEntity test1(@PathVariable @ApiParam(value = "测试信息param") String info){
        if(info.equals("ss")){
            return new ResponseEntity( "true",HttpStatus.OK);
        }else {
            return new ResponseEntity("false",HttpStatus.BAD_REQUEST);
        }
    }

}
