package com.example.demo.controller;

import com.example.demo.dto.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/yay")
@SwaggerDefinition(tags = {@Tag(name = "test")})
@Api(tags = "myTag", value = "@API VALUE")
public class TestController {
    @GetMapping("/userTest/camelCase/wow")
    @ApiOperation(value = "ApiOperation VALUE")
    public void test(){
        //impl
    }

    @GetMapping("/userTest/queryTest/{data}")
    @ApiParam(name="Api Param Name",value ="ApiParam Description", required = true)
    @ApiOperation(value = "ApiOperation VALUE",tags = "test tag",produces = "application/json")
    public String test2(@PathVariable String data){
        return data;
    }

    @GetMapping("/Rami")
    @ApiOperation(value = "get user",response = User.class)
    public User getUser(){
        return new User(20006, "Rami Samara", "Amman");
   }

}
