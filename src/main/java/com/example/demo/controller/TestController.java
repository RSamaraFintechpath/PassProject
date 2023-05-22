package com.example.demo.controller;

import com.example.demo.dto.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@SwaggerDefinition(
        info = @Info(
                title = "My API",
                version = "1.0",
                description = "API for managing products",
                contact = @Contact(
                        name = "John Doe",
                        email = "johndoe@example.com",
                        url = "https://example.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class TestController {
    @GetMapping("/userTest/camelCase")
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

    @GetMapping("/getUser")
    @ApiOperation(value = "get user",response = User.class)
    public User getUser(){
        return new User(20006, "Rami Samara", "Amman");
   }

}
