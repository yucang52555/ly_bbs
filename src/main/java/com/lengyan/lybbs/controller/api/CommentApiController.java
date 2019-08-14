package com.lengyan.lybbs.controller.api;

import com.lengyan.lybbs.exception.ApiAssert;
import com.lengyan.lybbs.model.Comment;
import com.lengyan.lybbs.model.Topic;
import com.lengyan.lybbs.service.CommentService;
import com.lengyan.lybbs.service.TopicService;
import com.lengyan.lybbs.util.Result;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/comment")
public class CommentApiController extends BaseApiController {

  @Autowired
  private CommentService commentService;
  @Autowired
  private TopicService topicService;

  // 创建评论
  @PostMapping("/create")
  public Result create(String content, Integer topicId, Integer commentId, HttpSession session) {
    ApiAssert.notEmpty(content, "请输入评论内容");
    ApiAssert.notNull(topicId, "话题ID呢？");
    Topic topic = topicService.selectById(topicId);
    ApiAssert.notNull(topic, "你晚了一步，话题可能已经被删除了");
    Comment comment = commentService.insert(content, topic, getUser(), commentId, session);
    return success(comment);
  }

  // 更新评论
  @PostMapping("/update")
  public Result update(Integer id, String content) {
    ApiAssert.notNull(id, "评论ID呢？");
    ApiAssert.notEmpty(content, "请输入评论内容");
    Comment comment = commentService.selectById(id);
    ApiAssert.notNull(comment, "这个评论可能已经被删除了，多发点对别人有帮助的评论吧");
    comment.setContent(Jsoup.clean(content, Whitelist.relaxed()));
    commentService.update(comment);
    return success(comment);
  }

  // 删除评论
  @GetMapping("/delete")
  public Result delete(Integer id, HttpSession session) {
    commentService.delete(id, session);
    return success();
  }
}
