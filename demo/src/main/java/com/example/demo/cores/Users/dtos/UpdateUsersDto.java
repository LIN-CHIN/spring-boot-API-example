package com.example.demo.cores.Users.dtos;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import com.example.demo.cores.Users.Users;

import jakarta.validation.constraints.Size;

public class UpdateUsersDto {
    public UpdateUsersDto() {
    }

    @Getter
    @Setter
    @NotNull(message = "Name is required")
    private String name;

    @Getter
    @Setter
    @NotNull(message = "Password is required")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String pwd;

    @Getter
    @Setter
    @Max(value = 20, message = "Phone must be less than 20 characters")
    private String phone;

    @Getter
    @Setter
    @Max(value = 100, message = "Email must be less than 100 characters")
    private String email;

    @Getter
    @Setter
    @Max(value = 255, message = "Address must be less than 255 characters")
    private String address;

    @Getter
    @Setter
    private String remark;

    public Users UpdateEntity(Users users) {
        users.setName(name);
        users.setPwd(pwd);
        users.setPhone(phone);
        users.setEmail(email);
        users.setAddress(address);
        users.setRemark(remark);
        users.setUpdateDate(LocalDateTime.now());
        return users;
    }
}
