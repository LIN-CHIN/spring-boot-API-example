package com.example.demo.cores.Test;

import org.springframework.web.bind.annotation.*;
import com.example.demo.common.exception.BusinessException;
import com.example.demo.common.responses.GenericResponse;

@RestController
@RequestMapping("/api/test-rename")
public class TestMethodRenameController {

    /**
     * 測試成功響應
     * 驗證 getDescription() 方法是否正常工作
     */
    @GetMapping("/success")
    public GenericResponse<String> testSuccess() {
        return GenericResponse.GetSuccessResponse("測試成功");
    }

    /**
     * 測試預期內的業務異常
     * 驗證 BusinessException.getDescription() 方法是否正常工作
     */
    @GetMapping("/expected-error")
    public GenericResponse<String> testExpectedError() {
        throw new BusinessException(10001, "這是預期內的業務錯誤");
    }

    /**
     * 測試非預期異常
     * 驗證系統錯誤處理是否正常工作
     */
    @GetMapping("/unexpected-error")
    public GenericResponse<String> testUnexpectedError() {
        throw new RuntimeException("這是非預期的系統錯誤");
    }
}
