package com.lengyan.lybbs.directive;

import com.lengyan.lybbs.model.Topic;
import com.lengyan.lybbs.service.TopicService;
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
public class OtherTopicDirective implements TemplateDirectiveModel {

  @Autowired
  private TopicService topicService;

  @Override
  public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                      TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
    Integer userId = Integer.parseInt(map.get("userId").toString());
    Integer topicId = Integer.parseInt(map.get("topicId").toString());
    Integer limit = Integer.parseInt(map.get("limit").toString());
    List<Topic> topics = topicService.selectAuthorOtherTopic(userId, topicId, limit);

    DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_28);
    environment.setVariable("topics", builder.build().wrap(topics));
    templateDirectiveBody.render(environment.getOut());
  }
}
