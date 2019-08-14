package com.lengyan.lybbs.controller.api;

import com.lengyan.lybbs.exception.ApiAssert;
import com.lengyan.lybbs.model.Topic;
import com.lengyan.lybbs.service.TopicService;
import com.lengyan.lybbs.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@RestController
@RequestMapping("/api/topic")
public class TopicApiController extends BaseApiController {

  @Autowired
  private TopicService topicService;

  // 保存话题
  @PostMapping("/create")
  public Result create(String title, String content, String tags, HttpSession session) {
    ApiAssert.notEmpty(title, "请输入标题");
    ApiAssert.notEmpty(tags, "请输入标签");
    ApiAssert.notTrue(StringUtils.commaDelimitedListToStringArray(tags).length > 5, "标签最多5个");
    //保存话题
    Topic topic = topicService.insertTopic(title, content, tags, getUser(), session);
    return success(topic);
  }

  // 更新话题
  @PostMapping("/edit")
  public Result edit(Integer id, String title, String content, String tags) {
    ApiAssert.notEmpty(title, "请输入标题");
    ApiAssert.notEmpty(tags, "请输入标签");
    ApiAssert.notTrue(StringUtils.commaDelimitedListToStringArray(tags).length > 5, "标签最多5个");
    // 更新话题
    Topic topic = topicService.selectById(id);
    ApiAssert.isTrue(topic.getUserId().equals(getUser().getId()), "谁给你的权限修改别人的话题的？");
    topic = topicService.updateTopic(topic, title, content, tags);
    return success(topic);
  }

  // 删除话题
  @GetMapping("/delete")
  public Result delete(Integer id, HttpSession session) {
    Topic topic = topicService.selectById(id);
    ApiAssert.isTrue(topic.getUserId().equals(getUser().getId()), "谁给你的权限删除别人的话题的？");
    topicService.delete(topic, session);
    return success();
  }
}
