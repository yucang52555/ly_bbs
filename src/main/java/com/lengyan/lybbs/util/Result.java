package com.lengyan.lybbs.util;

/**
 * Created by lengyan.
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top/
 */
public class Result {

  private Integer code;
  private String description;
  private Object detail;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Object getDetail() {
    return detail;
  }

  public void setDetail(Object detail) {
    this.detail = detail;
  }
}
