package com.grepp.javatokotlinmytest.controller;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String name;
    private String email;

}
