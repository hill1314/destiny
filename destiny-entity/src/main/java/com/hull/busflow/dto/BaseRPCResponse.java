package com.hull.busflow.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : LI-JIAN
 * Date   : 2017-12-13
 */
public class BaseRPCResponse<T> implements RPCResponse {
    protected static final long serialVersionUID = -1L;

    int code = 0;//success == 0
    String msg;
    T data;
    Map<String, Object> extMap = new HashMap<String, Object>();//拓展使用

    public BaseRPCResponse() {
    }

    public BaseRPCResponse(T data) {
        this.data = data;
    }

    public BaseRPCResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public BaseRPCResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Map<String, Object> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, Object> extMap) {
        this.extMap = extMap;
    }

    public boolean isSuccess() {
        return code == 0;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BaseRPCResponse{");
        sb.append("code=").append(code);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append(", extMap=").append(extMap);
        sb.append('}');
        return sb.toString();
    }
}
