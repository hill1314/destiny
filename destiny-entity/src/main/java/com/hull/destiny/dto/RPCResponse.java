package com.hull.destiny.dto;

import java.io.Serializable;

/**
 * Author : LI-JIAN
 * Date   : 2017-12-13
 */
public interface RPCResponse<T> extends Serializable {

    boolean isSuccess();//是否成功

    int getCode();

    String getMsg();

    T getData();

}
