package com.hull.busflow.po.lottery;

import com.hull.busflow.common.BaseEntity;

import java.util.Date;

/**
WARNING: 
this code is generated by CodeMonkey
please DO NOT modify this file
**/
public class LotSystemConfig extends BaseEntity {
  private Integer sysId;
  /**
  配置名称
  **/
  private String scName;
  /**
  配置值
  **/
  private Integer scValue;
  private Date scUpdateTime;
  private Date scCreateTime;

  public Integer getSysId() {
  	return sysId;
  }
	
  public void setSysId(Integer sysId) {
    this.sysId = sysId;
  }
	
  public String getScName() {
  	return scName;
  }
	
  public void setScName(String scName) {
    this.scName = scName;
  }
	
  public Integer getScValue() {
  	return scValue;
  }
	
  public void setScValue(Integer scValue) {
    this.scValue = scValue;
  }
	
  public Date getScUpdateTime() {
  	return scUpdateTime;
  }
	
  public void setScUpdateTime(Date scUpdateTime) {
    this.scUpdateTime = scUpdateTime;
  }
	
  public Date getScCreateTime() {
  	return scCreateTime;
  }
	
  public void setScCreateTime(Date scCreateTime) {
    this.scCreateTime = scCreateTime;
  }
	
}
