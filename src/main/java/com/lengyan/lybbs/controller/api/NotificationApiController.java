package com.lengyan.lybbs.controller.api;

import com.lengyan.lybbs.service.NotificationService;
import com.lengyan.lybbs.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@RestController
@RequestMapping("/api/notification")
public class NotificationApiController extends BaseApiController {

  @Autowired
  private NotificationService notificationService;

  @GetMapping("/notRead")
  public Result notRead() {
    return success(notificationService.countNotRead(getUser().getId()));
  }
}
