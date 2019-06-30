package com.hull.busflow.api.web;

import com.hull.busflow.po.web.DesVisitLog;

/**
 * 前端访问相关接口
 *
 * @author
 * @create 2018-09-15 下午9:46
 **/

public interface WebApi {

    /**
     * 发送客户访问信息，保存记录，返回 访问的序号
     * @param custHost
     * @return
     */
    DesVisitLog sendVisitRecord(String custHost);


}
