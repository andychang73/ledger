package com.abstractionizer.module.error;

public enum Error implements BaseError{

    ACCOUNT_NOT_FOUND(400,"000001", "Invalid account id"),
    WALLET_NOT_FOUND(400, "000002", "Invalid wallet id"),
    ASSET_TYPE_NOT_SAME(500,"000003", "Asset type not the same"),
    INSUFFICIENT_FUND(500, "000004", "Insufficient fund"),
    ILLEGAL_ACCOUNT_STATE_TO_MOVE(500,"000005", "Account state is not 'OPEN'"),
    TRANSACTION_ERROR(500, "000005", "Something went wrong during transaction"),


    DATA_NOT_FOUND(400, "002001", "Data not found"),
    CREATE_DATA_FAILED(400, "002003", "Failed to create data"),
    UPDATE_DATA_FAILED(400, "002004", "Update data failed")
    ;
    private final int httpStatus;
    private final String code;
    private final String message;

    Error(int httpStatus, String code, String message){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
