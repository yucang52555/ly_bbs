package com.lengyan.lybbs.controller.api;

import com.lengyan.lybbs.controller.front.BaseController;
import com.lengyan.lybbs.util.Result;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
public class BaseApiController extends BaseController {

  protected Result success() {
    return success(null);
  }

  protected Result success(Object detail) {
    Result result = new Result();
    result.setCode(200);
    result.setDescription("SUCCESS");
    result.setDetail(detail);
    return result;
  }

  protected Result error(String description) {
    Result result = new Result();
    result.setCode(201);
    result.setDescription(description);
    return result;
  }
}
