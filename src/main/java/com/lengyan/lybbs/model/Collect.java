package com.lengyan.lybbs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top/
 */
public class Collect implements Serializable {

  private static final long serialVersionUID = 7610730966340643542L;
  private Integer topicId;
  private Integer userId;
  private Date inTime;

  public Integer getTopicId() {
    return topicId;
  }

  public void setTopicId(Integer topicId) {
    this.topicId = topicId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Date getInTime() {
    return inTime;
  }

  public void setInTime(Date inTime) {
    this.inTime = inTime;
  }
}
