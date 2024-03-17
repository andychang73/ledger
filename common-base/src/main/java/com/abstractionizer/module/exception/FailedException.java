package com.abstractionizer.module.exception;

import com.abstractionizer.module.error.BaseError;

public class FailedException extends BaseException{

    public FailedException(BaseError error){
        this(error, null);
    }

    public FailedException(BaseError error, String details){
        this(error.getHttpStatus(), error.getCode(), error.getMessage(), details);
    }

    public FailedException(int httpStatus, String code, String message, String details){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.details = details;
    }
}
