package com.lengyan.lybbs.config;

import com.lengyan.lybbs.interceptor.CommonInterceptor;
import com.lengyan.lybbs.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

  @Autowired
  private CommonInterceptor commonInterceptor;
  @Autowired
  private UserInterceptor userInterceptor;

  @Override
  protected void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/notifications").setViewName("front/notifications");
    registry.addViewController("/login").setViewName("front/login");
    registry.addViewController("/register").setViewName("front/register");
    registry.addViewController("/api").setViewName("front/api");
  }

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    // 配置全局日志拦截器
    registry.addInterceptor(commonInterceptor)
        .addPathPatterns("/**");
    registry.addInterceptor(userInterceptor)
        .addPathPatterns(
            "/settings",
            "/topic/create",
            "/topic/edit/*",
            "/api/topic/create",
            "/api/topic/edit",
            "/api/topic/delete",
            "/api/comment/create",
            "/api/collect/get",
            "/api/collect/delete",
            "/api/settings/*",
            "/api/notification/notRead"
        );
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/", "file:./static/");
  }
}
