package com.hull.destiny.po.web;

import com.hull.destiny.common.BaseEntity;

import java.util.Date;

/**
 *
 * 客户访问记录
 *
 * @author
 * @create 2018-09-15 下午9:56
 **/

public class DesVisitLog extends BaseEntity{

    private Long id;
    private String host; //IP 地址
    private String visitDate; //日期
    private Long daySeq; //日排名
    private Long seq; //总排名
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public Long getDaySeq() {
        return daySeq;
    }

    public void setDaySeq(Long daySeq) {
        this.daySeq = daySeq;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
