package com.lengyan.lybbs.mapper;

import com.lengyan.lybbs.model.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
public interface TagMapper extends BaseMapper<Tag> {

  IPage<Map<String, Object>> selectTopicByTagId(IPage<Map<String, Object>> iPage, @Param("tagId") Integer tagId);
}
