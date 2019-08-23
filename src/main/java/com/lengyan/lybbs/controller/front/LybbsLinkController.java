package com.lengyan.lybbs.controller.front;

import com.lengyan.lybbs.model.Comment;
import com.lengyan.lybbs.model.LybbsLink;
import com.lengyan.lybbs.model.Topic;
import com.lengyan.lybbs.service.CommentService;
import com.lengyan.lybbs.service.LybbsLinkService;
import com.lengyan.lybbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@Controller
@RequestMapping("/links")
public class LybbsLinkController extends BaseController {

  @Autowired
  private LybbsLinkService linkService;

  // 获取所有链接
  @GetMapping("/all")
  public String all(@PathVariable Integer id, Model model) {
    List<LybbsLink> links = linkService.selectAll();
    model.addAttribute("links", links);
    return "front/components/links";
  }
}
