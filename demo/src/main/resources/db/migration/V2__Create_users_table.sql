-- 創建 users 表
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    pwd VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(255),
    remark TEXT,
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL
);

-- 創建索引
CREATE INDEX idx_users_name ON users(name);
CREATE INDEX idx_users_email ON users(email);
