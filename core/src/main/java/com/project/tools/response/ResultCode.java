package com.project.tools.response;

/**
 *
 */
public enum ResultCode {

    SUCCESS(1,"成功"),
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_BIND_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),

    USER_NOT_LOGGED_IN(2001,"用户未登录！"),
    USER_LOGIN_ERROR(2002,"账号不存在或密码为空！")
    ;

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }



}
