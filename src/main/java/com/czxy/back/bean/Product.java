package com.czxy.back.bean;


import java.util.Date;

public class Product {

  private Integer id;
  private String name;
  private String desc;
  private double price;
  private Category category;
  private Integer stock;
  private String provide;
  private Integer status;
  private Date createTime;
  private Date lastEditTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getProvide() {
    return provide;
  }

  public void setProvide(String provide) {
    this.provide = provide;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getLastEditTime() {
    return lastEditTime;
  }

  public void setLastEditTime(Date lastEditTime) {
    this.lastEditTime = lastEditTime;
  }

}
