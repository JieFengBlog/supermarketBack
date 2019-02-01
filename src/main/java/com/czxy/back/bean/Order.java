package com.czxy.back.bean;


import java.util.Date;

public class Order {

  private Integer id;
  private String orderNumber;
  private double orderPrice;
  private String orderProvide;
  private Integer userId;
  private Integer orderStatus;
  private Integer orderType;
  private Date createTime;
  private Date settlementTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(double orderPrice) {
    this.orderPrice = orderPrice;
  }

  public String getOrderProvide() {
    return orderProvide;
  }

  public void setOrderProvide(String orderProvide) {
    this.orderProvide = orderProvide;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Integer orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Integer getOrderType() {
    return orderType;
  }

  public void setOrderType(Integer orderType) {
    this.orderType = orderType;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getSettlementTime() {
    return settlementTime;
  }

  public void setSettlementTime(Date settlementTime) {
    this.settlementTime = settlementTime;
  }
}
