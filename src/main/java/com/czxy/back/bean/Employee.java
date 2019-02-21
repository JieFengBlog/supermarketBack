package com.czxy.back.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Employee  implements Serializable {

  private Integer id;
  private String name;
  private Integer gender;
  private String number;
  private String phone;
  private String address;
  private Date startTime;
  private String role;

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

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getStartTime() {
    return startTime;
  }

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", gender=" + gender +
            ", number='" + number + '\'' +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", startTime=" + startTime +
            ", role='" + role + '\'' +
            '}';
  }
}
