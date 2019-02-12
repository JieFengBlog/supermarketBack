package com.czxy.back.bean;


public class OrderDetail {

  private Integer id;
  private Integer productId;
  private Integer orderId;
  private String productName;
  private String productDesc;
  private double productPrice;
  private Integer productAmount;
  private double amountOfMoney;
  private Integer isProductExists;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }

  public Integer getProductAmount() {
    return productAmount;
  }

  public void setProductAmount(Integer productAmount) {
    this.productAmount = productAmount;
  }

  public double getAmountOfMoney() {
    return amountOfMoney;
  }

  public void setAmountOfMoney(double amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  public Integer getIsProductExists() {
    return isProductExists;
  }

  public void setIsProductExists(Integer isProductExists) {
    this.isProductExists = isProductExists;
  }
}
