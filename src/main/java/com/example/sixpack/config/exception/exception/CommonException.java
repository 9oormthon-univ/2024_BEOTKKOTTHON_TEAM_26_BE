package com.example.sixpack.config.exception.exception;

import java.util.List;

public class CommonException extends RuntimeException {
    private ErrorCode errorCode;
    private List<String> args;

    public CommonException(ErrorCode errorCode, List<String> args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public CommonException(ErrorCode errorCode) {
        this(errorCode, null);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public List<String> getArgs() {
        return args;
    }
}
