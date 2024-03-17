package com.abstractionizer.module.exception;

import com.abstractionizer.module.error.BaseError;

public class DeclineException extends BaseException{

    public DeclineException(BaseError error){
        this(error, null);
    }

    public DeclineException(BaseError error, String details){
        this(error.getHttpStatus(), error.getCode(), error.getMessage(), details);
    }

    public DeclineException(int httpStatus, String code, String message, String details){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.details = details;
    }
}
