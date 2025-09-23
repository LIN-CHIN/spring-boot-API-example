package com.example.demo.cores.Users.services;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.common.exception.BusinessException;
import com.example.demo.cores.Users.Users;
import com.example.demo.cores.Users.dtos.InsertUsersDto;
import com.example.demo.cores.Users.dtos.QueryUsersDto;
import com.example.demo.cores.Users.dtos.UpdateUsersDto;
import com.example.demo.cores.Users.dtos.UpdateUsersPwdDto;
import com.example.demo.cores.Users.repositories.UsersRepository;
import com.example.demo.cores.Users.specification.UserSpecification;

import java.util.List;
import com.example.demo.common.responses.ResponseCode;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> Get(QueryUsersDto queryDto) {
        // 使用 Specification 進行動態查詢
        Specification<Users> spec = UserSpecification.createSpecification(queryDto);
        return usersRepository.findAll(spec);
    }

    public Users GetById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException(ResponseCode.NOT_FOUND_ID,
                                "User not found with id: " + id));
    }

    public Users GetByName(String name) {
        return usersRepository.findByName(name)
                .orElseThrow(
                        () -> new BusinessException(ResponseCode.NOT_FOUND_NAME,
                                "User not found with name: " + name));
    }

    public Users Create(InsertUsersDto insertDto) {
        return usersRepository.save(insertDto.toEntity());
    }

    public Users Update(UpdateUsersDto updateDto, Long id) {
        Users users = usersRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException(ResponseCode.NOT_FOUND_ID,
                                "User not found with id: " + id));

        users = updateDto.UpdateEntity(users);
        return usersRepository.save(users);
    }

    public Users UpdatePwd(UpdateUsersPwdDto updateDto, Long id) {
        Users users = usersRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException(ResponseCode.NOT_FOUND_ID,
                                "User not found with id: " + id));

        users = updateDto.UpdateEntity(users);
        return usersRepository.save(users);
    }

    public void Delete(Long id) {
        Users users = usersRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException(ResponseCode.NOT_FOUND_ID,
                                "User not found with id: " + id));

        usersRepository.delete(users);
    }
}
