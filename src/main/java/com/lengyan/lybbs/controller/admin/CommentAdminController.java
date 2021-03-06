package com.lengyan.lybbs.controller.admin;

import com.lengyan.lybbs.model.Comment;
import com.lengyan.lybbs.model.Topic;
import com.lengyan.lybbs.service.CommentService;
import com.lengyan.lybbs.service.TopicService;
import com.lengyan.lybbs.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController extends BaseAdminController {

  @Autowired
  private CommentService commentService;
  @Autowired
  private TopicService topicService;

  @RequiresPermissions("comment:list")
  @GetMapping("/list")
  public String list(@RequestParam(defaultValue = "1") Integer pageNo, String startDate, String endDate, String username,
                     Model model) {
    if (StringUtils.isEmpty(startDate)) startDate = null;
    if (StringUtils.isEmpty(endDate)) endDate = null;
    if (StringUtils.isEmpty(username)) username = null;
    IPage<Map<String, Object>> page = commentService.selectAllForAdmin(pageNo, startDate, endDate, username);
    model.addAttribute("page", page);
    model.addAttribute("startDate", startDate);
    model.addAttribute("endDate", endDate);
    model.addAttribute("username", username);
    return "admin/comment/list";
  }

  @RequiresPermissions("comment:edit")
  @GetMapping("/edit")
  public String edit(Integer id, Model model) {
    Comment comment = commentService.selectById(id);
    Topic topic = topicService.selectById(comment.getTopicId());
    model.addAttribute("comment", comment);
    model.addAttribute("topic", topic);
    return "admin/comment/edit";
  }

  @RequiresPermissions("comment:edit")
  @PostMapping("/edit")
  @ResponseBody
  public Result update(Integer id, String content) {
    Comment comment = commentService.selectById(id);
    comment.setContent(Jsoup.clean(content, Whitelist.relaxed()));
    commentService.update(comment);
    return success();
  }

  @RequiresPermissions("comment:delete")
  @GetMapping("/delete")
  @ResponseBody
  public Result delete(Integer id) {
    commentService.delete(id, null);
    return success();
  }
}
