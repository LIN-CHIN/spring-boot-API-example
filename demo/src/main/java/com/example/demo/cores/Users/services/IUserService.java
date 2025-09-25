package com.example.demo.cores.Users.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.demo.cores.Users.dtos.QueryUsersDto;
import com.example.demo.cores.Users.dtos.InsertUsersDto;
import com.example.demo.cores.Users.dtos.UpdateUsersDto;
import com.example.demo.cores.Users.dtos.UpdateUsersPwdDto;
import com.example.demo.cores.Users.Users;

/**
 * 使用者服務介面
 * 定義使用者相關業務邏輯的方法規範
 */
public interface IUserService {

    /**
     * 根據查詢條件取得使用者列表（非同步）
     * 
     * @param queryDto 查詢條件物件
     * @return 符合條件的使用者列表的 CompletableFuture
     */
    CompletableFuture<List<Users>> GetAsync(QueryUsersDto queryDto);

    /**
     * 根據使用者ID取得單一使用者資訊
     * 
     * @param id 使用者ID
     * @return 使用者物件，若找不到則拋出例外
     */
    CompletableFuture<Users> GetByIdAsync(Long id);

    /**
     * 根據使用者姓名取得單一使用者資訊
     * 
     * @param name 使用者姓名
     * @return 使用者物件，若找不到則拋出例外
     */
    CompletableFuture<Users> GetByNameAsync(String name);

    /**
     * 建立新的使用者
     * 
     * @param insertDto 新增使用者的資料傳輸物件
     * @return 建立成功的使用者物件
     */
    CompletableFuture<Users> CreateAsync(InsertUsersDto insertDto);

    /**
     * 更新使用者基本資訊
     * 
     * @param updateDto 更新使用者的資料傳輸物件
     * @param id        要更新的使用者ID
     * @return 更新後的使用者物件
     */
    CompletableFuture<Users> UpdateAsync(UpdateUsersDto updateDto, Long id);

    /**
     * 更新使用者密碼
     * 
     * @param updateDto 更新密碼的資料傳輸物件
     * @param id        要更新密碼的使用者ID
     * @return 更新後的使用者物件
     */
    CompletableFuture<Users> UpdatePwdAsync(UpdateUsersPwdDto updateDto, Long id);

    /**
     * 刪除使用者
     * 
     * @param id 要刪除的使用者ID
     */
    CompletableFuture<Void> DeleteAsync(Long id);
}