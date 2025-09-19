package com.example.demo.cores.Users.dtos;

import lombok.Getter;
import lombok.Setter;

public class QueryUsersDto {
    public QueryUsersDto() {
    }

    public QueryUsersDto(String name) {
        this.name = name;
    }

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String remark;
}
