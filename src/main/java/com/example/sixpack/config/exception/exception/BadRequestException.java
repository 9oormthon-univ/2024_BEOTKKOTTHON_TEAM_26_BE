package com.example.sixpack.config.exception.exception;

public class BadRequestException extends CommonException {
    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST);
    }
}
