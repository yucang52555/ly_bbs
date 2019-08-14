package com.lengyan.lybbs.mapper;

import com.lengyan.lybbs.model.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
public interface CommentMapper extends BaseMapper<Comment> {

  @Select("select c.*, u.username, u.avatar, u.id as userId " +
      "from comment c " +
      "left join user u on c.user_id = u.id " +
      "where c.topic_id = #{topicId}")
  List<Map<String, Object>> selectByTopicId(@Param("topicId") Integer topicId);

  IPage<Map<String, Object>> selectByUserId(IPage<Map<String, Object>> iPage, @Param("userId") Integer userId);

  IPage<Map<String, Object>> selectAllForAdmin(
      IPage<Map<String, Object>> iPage,
      @Param("startDate") String startDate,
      @Param("endDate") String endDate,
      @Param("username") String username
  );
}
