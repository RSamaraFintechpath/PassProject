package com.example.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class User {
    @ApiModelProperty(name="userId", position = 1, example = "42354")
    private int userID;
    @ApiModelProperty(name = "userName", position = 2, example = "Rami Samara")
    private String userName;
    @ApiModelProperty(name= "address", position = 3, example= "Amman")
    private String address;
}
