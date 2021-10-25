package com.pengfu.mynav.util;

/**
 * @author PrideZH
 * @date 2021/10/20 - 20:58
 */
public enum ResultCode {

    /* 成功 */
    SUCCESS(200, "OK"),
    /* 失败 */
    FAIL(400, "请求错误"),
    ERROR(500, "服务器内部错误"),
    /* 参数错误 */
    PARAM_IS_INVALID(1001, "无效参数"),
    PARAM_IS_LACK(1002, "缺少参数");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
