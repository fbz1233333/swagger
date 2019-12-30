package com.example.swagger.domain;

import java.util.Date;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UserSqlInput输入返回体",description = "userInput输入返回体")
public class User {

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value =  "用户密码")
    private String password;

    @ApiModelProperty(value =  "用户DEL")
    private Integer isDel;

    @ApiModelProperty(value = "由谁创建")
    private String createBy;

    @ApiModelProperty(value  = "由谁修改")
    private String updateBy;

    @ApiModelProperty(value ="创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
