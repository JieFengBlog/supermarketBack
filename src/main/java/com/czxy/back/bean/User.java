package com.czxy.back.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {

  private Integer id;
  private String name;
  private String phone;
  private String email;
  private String address;
  private Integer userStatus;
  private Date registerTime;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", address='" + address + '\'' +
            ", userStatus=" + userStatus +
            ", registerTime=" + registerTime +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }

  public Date getRegisterTime() {
    return registerTime;
  }

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  public void setRegisterTime(Date registerTime) {
    this.registerTime = registerTime;
  }
}
