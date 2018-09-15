package com.hull.destiny.common.bean.dto;

/**
 * 接口请求包装类
 *
 * @author
 * @create 2018-09-15 下午9:01
 **/

public class ReqDTO {

    private String busiFrom;
    private String sign;
    private String token;
    private String url;
    private Object param;

    public String getBusiFrom() {
        return busiFrom;
    }

    public void setBusiFrom(String busiFrom) {
        this.busiFrom = busiFrom;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }
}
