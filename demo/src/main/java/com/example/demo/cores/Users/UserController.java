package com.example.demo.cores.Users;

import com.example.demo.cores.Users.dtos.InsertUsersDto;
import com.example.demo.cores.Users.dtos.QueryUsersDto;
import com.example.demo.cores.Users.dtos.UpdateUsersDto;
import com.example.demo.cores.Users.dtos.UpdateUsersPwdDto;
import com.example.demo.cores.Users.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<Users> Get(@ModelAttribute QueryUsersDto queryDto) {
        return userService.Get(queryDto);
    }

    @GetMapping("/{id}")
    public Users GetById(@PathVariable Long id) {
        return userService.GetById(id);
    }

    @GetMapping("/name/{name}")
    public Users GetByName(@PathVariable String name) {
        return userService.GetByName(name);
    }

    @PostMapping()
    public Users Create(@RequestBody InsertUsersDto insertDto) {
        return userService.Create(insertDto);
    }

    @PutMapping("/{id}")
    public Users Update(@RequestBody UpdateUsersDto updateDto, @PathVariable Long id) {
        return userService.Update(updateDto, id);
    }

    @PatchMapping("/{id}/pwd")
    public Users UpdatePwd(@RequestBody UpdateUsersPwdDto updateDto, @PathVariable Long id) {
        return userService.UpdatePwd(updateDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        userService.Delete(id);
        return ResponseEntity.noContent().build();
    }
}
