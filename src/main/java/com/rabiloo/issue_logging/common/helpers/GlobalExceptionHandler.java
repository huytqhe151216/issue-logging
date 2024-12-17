package com.rabiloo.issue_logging.common.helpers;

import com.rabiloo.issue_logging.common.models.ResponseResult;
import com.rabiloo.issue_logging.exceptions.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Xử lý CustomException
    @ExceptionHandler(CustomException.class)
    public ResponseResult<Void> handleCustomException(CustomException ex) {
        return ResponseResult.error(ex.getStatus(), ex.getMessage());
    }

    // Xử lý các lỗi khác (Exception)
    @ExceptionHandler(Exception.class)
    public ResponseResult<Void> handleGeneralException(Exception ex) {
        return ResponseResult.error(500, "Internal Server Error: " + ex.getMessage());
    }
}
