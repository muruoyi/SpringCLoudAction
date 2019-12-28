package com.muruoyi.cloudhystrixservice.model;

import lombok.Data;

@Data
public class ApiResult<T> {

    private Boolean succ;

    private String code;

    private String msg;

    private T data;
}