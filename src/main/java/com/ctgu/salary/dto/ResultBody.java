package com.ctgu.salary.dto;

/**
 * @Description 统一返回格式
 * @Author wh_lan
 * @create 2020-08-06 9:43
 * @ClassName ResultBody
 * @Version 1.0.0
 */
public class ResultBody {
    private String msg;
    private String statusCode;
    private Object result;

    public ResultBody() {
    }

    public ResultBody(String msg, String statusCode, Object result) {
        this.msg = msg;
        this.statusCode = statusCode;
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getObject() {
        return result;
    }

    public void setObject(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultBody{" +
                "msg='" + msg + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", result=" + result +
                '}';
    }
}
