package com.abstractionizer.module.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResp<T> {

    T data;

    public SuccessResp(){
        this.data = (T)"SUCCESS";
    }

    public SuccessResp(T data){
        this.data = data;
    }
}
