package com.example.sixpack.config.exception.exception;

public class NotFoundException extends CommonException {
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    @Override
    public ErrorCode getErrorCode() {
        return super.getErrorCode();
    }
}