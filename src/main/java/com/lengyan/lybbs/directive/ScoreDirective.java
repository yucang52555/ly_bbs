package com.lengyan.lybbs.directive;

import com.lengyan.lybbs.model.User;
import com.lengyan.lybbs.service.UserService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@Component
public class ScoreDirective implements TemplateDirectiveModel {

  @Autowired
  private UserService userService;

  @Override
  public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                      TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
    Integer limit = Integer.parseInt(map.get("limit").toString());
    if (limit > 100) limit = 100;
    List<User> users = userService.selectTop(limit);

    DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
    environment.setVariable("users", builder.build().wrap(users));
    templateDirectiveBody.render(environment.getOut());
  }
}
