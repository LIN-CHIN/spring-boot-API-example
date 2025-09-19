package com.example.demo.cores.Users;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

@Entity
@Table(name = "users")
public class Users {
    public Users() {
    }

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "name", nullable = false, unique = true, length = 50)
    @NotNull(message = "Name is required")
    private String name;

    @Getter
    @Setter
    @Column(name = "pwd", nullable = false, length = 255)
    @NotNull(message = "Password is required")
    private String pwd;

    @Getter
    @Setter
    @Column(name = "email", length = 100)
    private String email;

    @Getter
    @Setter
    @Column(name = "phone", length = 20)
    private String phone;

    @Getter
    @Setter
    @Column(name = "address", length = 255)
    private String address;

    @Getter
    @Setter
    @Column(name = "remark", columnDefinition = "TEXT")
    private String remark;

    @Getter
    @Setter
    @Column(name = "create_date", nullable = false)
    @NotNull(message = "Create date is required")
    private LocalDateTime createDate;

    @Getter
    @Setter
    @Column(name = "update_date", nullable = false)
    @NotNull(message = "Update date is required")
    private LocalDateTime updateDate;

    @PrePersist // 在保存到數據庫前自動執行
    protected void onCreate() {
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }
}