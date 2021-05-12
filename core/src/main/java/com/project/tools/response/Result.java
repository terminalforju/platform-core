package com.project.tools.response;

import java.io.Serializable;

public class Result implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    //success
    public static Result success(){
        return success(null);
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    //error
    public static Result failure(ResultCode resultCode){
        return failure(resultCode,null);
    }

    public static Result failure(ResultCode resultCode,Object data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }





    private void setResultCode(ResultCode success) {
        this.code = success.getCode();
        this.message = success.getMessage();
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
}
