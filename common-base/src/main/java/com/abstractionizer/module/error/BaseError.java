package com.abstractionizer.module.error;

public interface BaseError {

    int getHttpStatus();

    String getCode();

    String getMessage();
}
