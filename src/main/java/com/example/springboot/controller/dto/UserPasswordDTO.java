package com.example.springboot.controller.dto;

import lombok.Data;

@Data
public class UserPasswordDTO {
    private String id;
    private String username;
    private String phone;
    private String password;
    private String newPassword;
}
