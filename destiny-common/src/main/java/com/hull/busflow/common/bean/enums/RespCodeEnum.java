package com.hull.busflow.common.bean.enums;

/**
 *
 *
 * @author
 * @create 2018-07-07 下午5:32
 **/

public enum RespCodeEnum {
    SUCCESS("0000", "success"),
    FAIL("1000", "操作失败"),
    BAD_REQUEST("400", "参数异常"),
    FORBIDDEN("403", "没有访问权限"),
    PAGE_NOT_FOUND("404", "页面不存在"),
    SERVER_ERROR("500", "服务器开小差"),
    NEED_LOGIN("600", "请先登录");

    private String code;
    private String msg;

    private RespCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
