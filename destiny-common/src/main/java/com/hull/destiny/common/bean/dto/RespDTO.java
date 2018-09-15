package com.hull.destiny.common.bean.dto;

/**
 *
 *
 * @author
 * @create 2018-07-07 下午5:27
 **/

import com.hull.destiny.common.bean.enums.RespCodeEnum;

import java.io.Serializable;

/**
 * 统一的返回对象
 */
public class RespDTO<T> implements Serializable {
    /**
     * 返回状态码
     */
    private String code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 只允许通过静态方法创建对象
     */
    private RespDTO() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> RespDTO<T> success() {
        RespDTO<T> resp = new RespDTO<T>();
        resp.code = RespCodeEnum.SUCCESS.getCode();
        resp.msg = RespCodeEnum.SUCCESS.getMsg();
        return resp;
    }

    public static <T> RespDTO<T> success(T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.code = RespCodeEnum.SUCCESS.getCode();
        resp.msg = RespCodeEnum.SUCCESS.getMsg();
        return resp;
    }

    public static <T> RespDTO<T> success(String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.msg = msg;
        resp.data = data;
        resp.code = RespCodeEnum.SUCCESS.getCode();
        resp.msg = RespCodeEnum.SUCCESS.getMsg();
        return resp;
    }

    public static <T> RespDTO<T> fail() {
        return fail(RespCodeEnum.FAIL.getMsg(), null);
    }

    public static <T> RespDTO<T> fail(String msg) {
        return fail(msg, null);
    }

    public static <T> RespDTO<T> fail(String code, String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.code = code;
        resp.msg = msg;
        return resp;
    }

    public static <T> RespDTO<T> fail(String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.code = RespCodeEnum.FAIL.getCode();
        resp.msg = msg;
        return resp;
    }

    public static <T> RespDTO<T> forbidden() {
        RespDTO<T> resp = new RespDTO<T>();
        resp.code = RespCodeEnum.FORBIDDEN.getCode();
        resp.msg = RespCodeEnum.FORBIDDEN.getMsg();
        return resp;

    }

    public static <T> RespDTO<T> badRequest() {
        return badRequest(RespCodeEnum.BAD_REQUEST.getMsg(), null);
    }

    public static <T> RespDTO<T> badRequest(String msg) {
        return badRequest(msg, null);
    }

    public static <T> RespDTO<T> badRequest(String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.code = RespCodeEnum.BAD_REQUEST.getCode();
        resp.msg = msg;
        return resp;
    }

    public static <T> RespDTO<T> error() {
        return error(RespCodeEnum.SERVER_ERROR.getMsg(), null);
    }

    public static <T> RespDTO<T> error(String msg) {
        return error(msg, null);
    }

    public static <T> RespDTO<T> error(String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.code = RespCodeEnum.SERVER_ERROR.getCode();
        resp.msg = msg;
        return resp;
    }

}
