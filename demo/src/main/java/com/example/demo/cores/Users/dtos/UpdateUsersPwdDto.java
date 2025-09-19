package com.example.demo.cores.Users.dtos;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

import com.example.demo.cores.Users.Users;

public class UpdateUsersPwdDto {
    @Getter
    @Setter
    @NotNull(message = "Password is required")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String pwd;

    public Users UpdateEntity(Users users) {
        users.setPwd(pwd);
        users.setUpdateDate(LocalDateTime.now());
        return users;
    }
}
