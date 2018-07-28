package com.mljr.destiny.common.bean.dto;

/**
 *
 *
 * @author
 * @create 2018-07-07 下午5:27
 **/

import com.mljr.destiny.common.bean.enums.RespStatusEnum;

import java.io.Serializable;

/**
 * 统一的返回对象
 */
public class RespDTO<T> implements Serializable {
    /**
     * 返回状态码
     */
    private int status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        resp.status = RespStatusEnum.SUCCESS.getStatus();
        resp.msg = RespStatusEnum.SUCCESS.getMsg();
        return resp;
    }

    public static <T> RespDTO<T> success(T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.status = RespStatusEnum.SUCCESS.getStatus();
        resp.msg = RespStatusEnum.SUCCESS.getMsg();
        return resp;
    }

    public static <T> RespDTO<T> success(String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.msg = msg;
        resp.data = data;
        resp.status = RespStatusEnum.SUCCESS.getStatus();
        resp.msg = RespStatusEnum.SUCCESS.getMsg();
        return resp;
    }

    public static <T> RespDTO<T> fail() {
        return fail(RespStatusEnum.FAIL.getMsg(), null);
    }

    public static <T> RespDTO<T> fail(String msg) {
        return fail(msg, null);
    }

    public static <T> RespDTO<T> fail(int status, String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.status = status;
        resp.msg = msg;
        return resp;
    }

    public static <T> RespDTO<T> fail(String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.status = RespStatusEnum.FAIL.getStatus();
        resp.msg = msg;
        return resp;
    }

    public static <T> RespDTO<T> forbidden() {
        RespDTO<T> resp = new RespDTO<T>();
        resp.status = RespStatusEnum.FORBIDDEN.getStatus();
        resp.msg = RespStatusEnum.FORBIDDEN.getMsg();
        return resp;

    }

    public static <T> RespDTO<T> badRequest() {
        return badRequest(RespStatusEnum.BAD_REQUEST.getMsg(), null);
    }

    public static <T> RespDTO<T> badRequest(String msg) {
        return badRequest(msg, null);
    }

    public static <T> RespDTO<T> badRequest(String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.status = RespStatusEnum.BAD_REQUEST.getStatus();
        resp.msg = msg;
        return resp;
    }

    public static <T> RespDTO<T> error() {
        return error(RespStatusEnum.SERVER_ERROR.getMsg(), null);
    }

    public static <T> RespDTO<T> error(String msg) {
        return error(msg, null);
    }

    public static <T> RespDTO<T> error(String msg, T data) {
        RespDTO<T> resp = new RespDTO<T>();
        resp.data = data;
        resp.status = RespStatusEnum.SERVER_ERROR.getStatus();
        resp.msg = msg;
        return resp;
    }

}
