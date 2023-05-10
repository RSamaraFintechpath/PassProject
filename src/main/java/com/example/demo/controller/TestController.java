package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/userTest/camelCase")
    @ApiParam(value="test", required = true)
    @ApiOperation(value = "test")
    public void test(){
        //impl
    }

    @GetMapping("/userTest/queryTest/{Data}")
    @ApiParam(value="test", required = true)
    @ApiOperation(value = "test")
    public String test2(@PathVariable String data){
        return data;
    }


}
