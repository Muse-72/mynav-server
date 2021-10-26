package com.pengfu.mynav.util;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author PrideZH
 * @date 2021/10/20 - 20:54
 */
@ApiModel("响应数据")
public class Result<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("响应信息")
    private String message;

    @ApiModelProperty("响应数据")
    private T data;

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> build(ResultCode resultCode, String message, T data) {
        return new Result<T>(resultCode.code(), message, data);
    }

    public static <T> Result<T> build(ResultCode resultCode, String message) {
        return new Result<T>(resultCode.code(), message, null);
    }

    public static <T> Result<T> build(ResultCode resultCode, T data) {
        return new Result<T>(resultCode.code(), resultCode.message(), data);
    }

    public static <T> Result<T> build(ResultCode resultCode) {
        return new Result<T>(resultCode.code(), resultCode.message(), null);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
