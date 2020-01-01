package com.example.swagger.controller;

import com.example.swagger.dto.TestDTO1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/test")
@Api(tags = "Test系列接口",description = "TEST系列接口的description")
public class TestController {


//    @ApiResponse(code = 401, message = "测试返回体")
    @ApiOperation(value = "测试TEST1",notes = "测试返回的ResponseEntity",httpMethod = "GET",response = ResponseEntity.class)
    @GetMapping("info/{info}")
    public ResponseEntity<String> test1(@PathVariable @ApiParam(value = "测试信息param") String info){
        if(info.equals("ss")){
            return new ResponseEntity<>( "true",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("false",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("infoDate")
    public ResponseEntity<TestDTO1> test2(){
        TestDTO1 testDTO1=new TestDTO1();
        testDTO1.setDate(new Date());
        return new ResponseEntity<>(testDTO1,HttpStatus.OK);
    }
}
