package com.mljr.destiny.common.entity;

import com.mljr.destiny.common.BaseEntity;

import java.util.Date;

/**
WARNING: 
this code is generated by CodeMonkey
please DO NOT modify this file
**/
public class PriPrizeInfoOrg extends BaseEntity {
  private Integer priId;
  /**
  奖品名称
  **/
  private String priName;
  /**
  奖品总量库存
  **/
  private Integer priAmount;
  /**
  奖品余量库存
  **/
  private Integer priInventory;
  private Date priUpdateTime;
  private Date priCreateTime;

  public Integer getPriId() {
  	return priId;
  }
	
  public void setPriId(Integer priId) {
    this.priId = priId;
  }
	
  public String getPriName() {
  	return priName;
  }
	
  public void setPriName(String priName) {
    this.priName = priName;
  }
	
  public Integer getPriAmount() {
  	return priAmount;
  }
	
  public void setPriAmount(Integer priAmount) {
    this.priAmount = priAmount;
  }
	
  public Integer getPriInventory() {
  	return priInventory;
  }
	
  public void setPriInventory(Integer priInventory) {
    this.priInventory = priInventory;
  }
	
  public Date getPriUpdateTime() {
  	return priUpdateTime;
  }
	
  public void setPriUpdateTime(Date priUpdateTime) {
    this.priUpdateTime = priUpdateTime;
  }
	
  public Date getPriCreateTime() {
  	return priCreateTime;
  }
	
  public void setPriCreateTime(Date priCreateTime) {
    this.priCreateTime = priCreateTime;
  }
	
}