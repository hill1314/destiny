package com.mljr.destiny.common.entity;

import com.mljr.destiny.common.BaseEntity;

import java.util.Date;

/**
WARNING: 
this code is generated by CodeMonkey
please DO NOT modify this file
**/
public class LotUserDrawTimes extends BaseEntity {
  private Integer utId;
  private String utUid;
  /**
  用户抽奖次数
  **/
  private Integer utTimes;
  /**
  用户抽奖记录id
  **/
  private Integer drawRecordId;
  private Date utCreateTime;
  private Date utUpdateTime;

  public Integer getUtId() {
  	return utId;
  }
	
  public void setUtId(Integer utId) {
    this.utId = utId;
  }
	
  public String getUtUid() {
  	return utUid;
  }
	
  public void setUtUid(String utUid) {
    this.utUid = utUid;
  }
	
  public Integer getUtTimes() {
  	return utTimes;
  }
	
  public void setUtTimes(Integer utTimes) {
    this.utTimes = utTimes;
  }
	
  public Integer getDrawRecordId() {
  	return drawRecordId;
  }
	
  public void setDrawRecordId(Integer drawRecordId) {
    this.drawRecordId = drawRecordId;
  }
	
  public Date getUtCreateTime() {
  	return utCreateTime;
  }
	
  public void setUtCreateTime(Date utCreateTime) {
    this.utCreateTime = utCreateTime;
  }
	
  public Date getUtUpdateTime() {
  	return utUpdateTime;
  }
	
  public void setUtUpdateTime(Date utUpdateTime) {
    this.utUpdateTime = utUpdateTime;
  }
	
}
