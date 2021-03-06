package com.lengyan.lybbs.controller.front;

import com.lengyan.lybbs.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
public class BaseController {

  protected String redirect(String path) {
    return "redirect:" + path;
  }

  protected User getUser() {
    HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    HttpSession session = request.getSession();
    return (User) session.getAttribute("_user");
  }

}
