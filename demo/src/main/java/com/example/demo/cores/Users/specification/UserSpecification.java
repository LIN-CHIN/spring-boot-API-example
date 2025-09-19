package com.example.demo.cores.Users.specification;

import com.example.demo.cores.Users.Users;
import com.example.demo.cores.Users.dtos.QueryUsersDto;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    public static Specification<Users> createSpecification(QueryUsersDto queryDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (queryDto == null) {
                return criteriaBuilder.conjunction();
            }

            if (queryDto.getName() != null && !queryDto.getName().trim().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + queryDto.getName().toLowerCase() + "%"));
            }

            if (queryDto.getPhone() != null && !queryDto.getPhone().trim().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("phone"), queryDto.getPhone()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
