package com.pengfu.mynav.util;

import com.alibaba.fastjson.JSON;

/**
 * @author PrideZH
 * @date 2021/10/20 - 20:54
 */
public class Result {

    /** 响应状态 */
    private Integer code;
    /** 响应消息 */
    private String message;
    /** 响应数据 */
    private Object data;

    public Result(Integer code, String message, Object data) {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result build(ResultCode resultCode, String message, Object data) {
        return new Result(resultCode.code(), message, data);
    }

    public static Result build(ResultCode resultCode, String message) {
        return new Result(resultCode.code(), message, null);
    }

    public static Result build(ResultCode resultCode, Object data) {
        return new Result(resultCode.code(), resultCode.message(), data);
    }

    public static Result build(ResultCode resultCode) {
        return new Result(resultCode.code(), resultCode.message(), null);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
