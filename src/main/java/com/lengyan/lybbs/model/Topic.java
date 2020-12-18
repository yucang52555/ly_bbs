package com.lengyan.lybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.elasticsearch.common.inject.internal.ToStringBuilder;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top/
 */
@Document(indexName = "article-search",type = "topic")
public class Topic implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(type = IdType.AUTO)
  private Integer id;

  @Field(type = FieldType.Text, analyzer = "ik_max_word")
  private String title;

  @Field(type = FieldType.Text)
  private String content;

  private Date inTime;
  private Date modifyTime;
  private Integer userId;
  // 评论数
  private Integer commentCount;
  // 收藏数
  private Integer collectCount;
  // 浏览数
  private Integer view;
  // 置顶
  private Boolean top;
  // 加精
  private Boolean good;

  public Integer getCollectCount() {
    return collectCount;
  }

  public void setCollectCount(Integer collectCount) {
    this.collectCount = collectCount;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getInTime() {
    return inTime;
  }

  public void setInTime(Date inTime) {
    this.inTime = inTime;
  }

  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Integer commentCount) {
    this.commentCount = commentCount;
  }

  public Integer getView() {
    return view;
  }

  public void setView(Integer view) {
    this.view = view;
  }

  public Boolean getTop() {
    return top;
  }

  public void setTop(Boolean top) {
    this.top = top;
  }

  public Boolean getGood() {
    return good;
  }

  public void setGood(Boolean good) {
    this.good = good;
  }

  @Override
  public String toString() {
    return "Topic{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", inTime=" + inTime +
            ", modifyTime=" + modifyTime +
            ", userId=" + userId +
            ", commentCount=" + commentCount +
            ", collectCount=" + collectCount +
            ", view=" + view +
            ", top=" + top +
            ", good=" + good +
            '}';
  }
}
