package com.abstractionizer.module.exception;

import com.abstractionizer.module.error.BaseError;

public class BusinessException extends BaseException{

    public BusinessException(BaseError error){
        this(error, null);
    }

    public BusinessException(BaseError error, String details){
        this(error.getHttpStatus(), error.getCode(), error.getMessage(), details);
    }

    public BusinessException(int httpStatus, String code, String message, String details){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.details = details;
    }
}
