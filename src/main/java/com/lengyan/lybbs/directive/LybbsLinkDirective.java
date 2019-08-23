package com.lengyan.lybbs.directive;

import com.lengyan.lybbs.model.LybbsLink;
import com.lengyan.lybbs.model.User;
import com.lengyan.lybbs.service.LybbsLinkService;
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
 * Copyright (c) 2019, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@Component
public class LybbsLinkDirective implements TemplateDirectiveModel {

  @Autowired
  private LybbsLinkService linkService;

  @Override
  public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                      TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
    List<LybbsLink> links = linkService.selectAll();

    DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
    environment.setVariable("links", builder.build().wrap(links));
    templateDirectiveBody.render(environment.getOut());
  }
}
