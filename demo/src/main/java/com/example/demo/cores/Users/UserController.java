package com.example.demo.cores.Users;

import com.example.demo.cores.Users.dtos.InsertUsersDto;
import com.example.demo.cores.Users.dtos.QueryUsersDto;
import com.example.demo.cores.Users.dtos.UpdateUsersDto;
import com.example.demo.cores.Users.dtos.UpdateUsersPwdDto;
import com.example.demo.cores.Users.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping()
    public CompletableFuture<List<Users>> Get(QueryUsersDto queryDto) {
        return userService.GetAsync(queryDto);
    }

    @GetMapping("/{id}")
    public CompletableFuture<Users> GetById(@PathVariable Long id) {
        return userService.GetByIdAsync(id);
    }

    @GetMapping("/name/{name}")
    public CompletableFuture<Users> GetByName(@PathVariable String name) {
        return userService.GetByNameAsync(name);
    }

    @PostMapping()
    public CompletableFuture<Users> Create(@RequestBody InsertUsersDto insertDto) {
        return userService.CreateAsync(insertDto);
    }

    @PutMapping("/{id}")
    public CompletableFuture<Users> Update(@RequestBody UpdateUsersDto updateDto, @PathVariable Long id) {
        return userService.UpdateAsync(updateDto, id);
    }

    @PatchMapping("pwd/{id}")
    public CompletableFuture<Users> UpdatePwd(@RequestBody UpdateUsersPwdDto updateDto,
            @PathVariable Long id) {
        return userService.UpdatePwdAsync(updateDto, id);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> Delete(@PathVariable Long id) {
        return userService.DeleteAsync(id);
    }
}
