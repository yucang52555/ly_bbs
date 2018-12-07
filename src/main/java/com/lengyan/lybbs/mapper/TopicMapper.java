package com.lengyan.lybbs.mapper;

import com.lengyan.lybbs.model.Topic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.Map;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://blog.ruzishici.top
 */
public interface TopicMapper extends BaseMapper<Topic> {

  IPage<Map<String, Object>> selectAll(
      IPage<Map<String, Object>> iPage,
      @Param("tab") String tab
  );

  IPage<Map<String, Object>> selectByTag(
      IPage<Map<String, Object>> iPage,
      @Param("tag") String tag
  );

  IPage<Map<String, Object>> selectByUserId(IPage<Map<String, Object>> iPage, @Param("userId") Integer userId);

  IPage<Map<String, Object>> selectAllForAdmin(
      IPage<Map<String, Object>> iPage,
      @Param("startDate") String startDate,
      @Param("endDate") String endDate,
      @Param("username") String username
  );
}
