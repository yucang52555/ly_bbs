package com.lengyan.lybbs.config;

import com.lengyan.lybbs.directive.*;
import com.lengyan.lybbs.service.SystemConfigService;
import com.lengyan.lybbs.util.BaseModel;
import freemarker.template.TemplateModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.annotation.PostConstruct;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@Configuration
public class FreemarkerConfig {

  private Logger log = LoggerFactory.getLogger(FreeMarkerConfig.class);

  @Autowired
  private freemarker.template.Configuration configuration;
  @Autowired
  private SystemConfigService systemConfigService;
  @Autowired
  private TopicListDirective topicListDirective;
  @Autowired
  private OtherTopicDirective otherTopicDirective;
  @Autowired
  private NotificationsDirective notificationsDirective;
  @Autowired
  private ScoreDirective scoreDirective;
  @Autowired
  private LybbsLinkDirective lybbsLinkDirective;
  @Autowired
  private BaseModel baseModel;
  @Autowired
  private ShiroTag shiroTag;

  @PostConstruct
  public void setSharedVariable() throws TemplateModelException {
    //注入全局配置到freemarker
    log.info("开始配置freemarker全局变量...");
    configuration.setSharedVariable("site", systemConfigService.selectAllConfig());
    configuration.setSharedVariable("model", baseModel);
    // shiro鉴权
    configuration.setSharedVariable("sec", shiroTag);
    log.info("freemarker全局变量配置完成!");

    log.info("开始配置freemarker自定义标签...");
    configuration.setSharedVariable("tag_topicList", topicListDirective);
    configuration.setSharedVariable("tag_otherTopic", otherTopicDirective);
    configuration.setSharedVariable("tag_notifications", notificationsDirective);
    configuration.setSharedVariable("tag_score", scoreDirective);
    configuration.setSharedVariable("tag_link", lybbsLinkDirective);
    log.info("freemarker自定义标签配置完成!");
  }

}
