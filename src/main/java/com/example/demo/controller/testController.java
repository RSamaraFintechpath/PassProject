package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class testController {
    @GetMapping("/usertest")
    @ApiParam(value="test", required = true)
    @ApiOperation(value = "test")
    public void test(){

    }
}