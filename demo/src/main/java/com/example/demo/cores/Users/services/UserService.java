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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import com.example.demo.common.responses.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService implements IUserService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private Executor taskExecutor;

    @Override
    public CompletableFuture<List<Users>> GetAsync(QueryUsersDto queryDto) {
        return CompletableFuture.supplyAsync(() -> {
            // 使用 Specification 進行動態查詢
            Specification<Users> spec = UserSpecification.createSpecification(queryDto);
            return usersRepository.findAll(spec);
        }, taskExecutor);
    }

    @Override
    public CompletableFuture<Users> GetByIdAsync(Long id) {
        return CompletableFuture.supplyAsync(() -> usersRepository.findById(id)
                .orElseThrow(
                        () -> new BusinessException(ResponseCode.NOT_FOUND_ID,
                                "User not found with id: " + id)),
                taskExecutor);
    }

    @Override
    public CompletableFuture<Users> GetByNameAsync(String name) {
        return CompletableFuture.supplyAsync(() -> usersRepository.findByName(name)
                .orElseThrow(
                        () -> new BusinessException(ResponseCode.NOT_FOUND_NAME,
                                "User not found with name: " + name)),
                taskExecutor);
    }

    @Override
    public CompletableFuture<Users> CreateAsync(InsertUsersDto insertDto) {
        return CompletableFuture.supplyAsync(() -> usersRepository.save(insertDto.toEntity()),
                taskExecutor);
    }

    @Override
    public CompletableFuture<Users> UpdateAsync(UpdateUsersDto updateDto, Long id) {
        return CompletableFuture.supplyAsync(() -> {
            Users users = usersRepository.findById(id)
                    .orElseThrow(
                            () -> new BusinessException(ResponseCode.NOT_FOUND_ID,
                                    "User not found with id: " + id));

            users = updateDto.UpdateEntity(users);
            return usersRepository.save(users);
        }, taskExecutor);
    }

    @Override
    public CompletableFuture<Users> UpdatePwdAsync(UpdateUsersPwdDto updateDto, Long id) {
        return CompletableFuture.supplyAsync(() -> {
            Users users = usersRepository.findById(id)
                    .orElseThrow(
                            () -> new BusinessException(ResponseCode.NOT_FOUND_ID,
                                    "User not found with id: " + id));

            users = updateDto.UpdateEntity(users);
            return usersRepository.save(users);
        }, taskExecutor);
    }

    @Override
    public CompletableFuture<Void> DeleteAsync(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            Users users = usersRepository.findById(id)
                    .orElseThrow(
                            () -> new BusinessException(ResponseCode.NOT_FOUND_ID,
                                    "User not found with id: " + id));

            usersRepository.delete(users);
            return null;
        }, taskExecutor);
    }
}
