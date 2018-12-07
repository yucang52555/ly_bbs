package com.lengyan.lybbs.controller.admin;

import com.lengyan.lybbs.controller.api.BaseApiController;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://blog.ruzishici.top
 */
public class BaseAdminController extends BaseApiController {

  // 可以将传递到controller里的参数中Date类型的从String转成Date类型的对象
  // 这货没有想象中的好用，还不如我手动控制String转Date了
  @InitBinder
  public void initBinder(ServletRequestDataBinder binder) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
  }

}
