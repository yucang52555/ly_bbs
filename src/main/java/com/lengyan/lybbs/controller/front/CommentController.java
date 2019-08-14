package com.lengyan.lybbs.controller.front;

import com.lengyan.lybbs.model.Comment;
import com.lengyan.lybbs.model.Topic;
import com.lengyan.lybbs.service.CommentService;
import com.lengyan.lybbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {

  @Autowired
  private CommentService commentService;
  @Autowired
  private TopicService topicService;

  // 编辑评论
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    Comment comment = commentService.selectById(id);
    Topic topic = topicService.selectById(comment.getTopicId());
    model.addAttribute("comment", comment);
    model.addAttribute("topic", topic);
    return "front/comment/edit";
  }
}
