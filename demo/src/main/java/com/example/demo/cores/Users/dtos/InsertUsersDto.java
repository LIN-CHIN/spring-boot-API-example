package com.example.demo.cores.Users.dtos;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.example.demo.cores.Users.Users;

import jakarta.validation.constraints.Email;

public class InsertUsersDto {
    public InsertUsersDto() {
    }

    @Getter
    @Setter
    @NotNull(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Getter
    @Setter
    @NotNull(message = "Password is required")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String pwd;

    @Getter
    @Setter
    @Email(message = "Invalid email address")
    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @Getter
    @Setter
    @Size(max = 20, message = "Phone must be less than 20 characters")
    private String phone;

    @Getter
    @Setter
    @Size(max = 255, message = "Address must be less than 255 characters")
    private String address;

    @Getter
    @Setter
    private String remark;

    public Users toEntity() {
        Users users = new Users();
        users.setName(name);
        users.setPwd(pwd);
        users.setEmail(email);
        users.setPhone(phone);
        users.setAddress(address);
        users.setRemark(remark);
        return users;
    }
}
