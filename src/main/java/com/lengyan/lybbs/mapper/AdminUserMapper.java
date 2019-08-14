package com.lengyan.lybbs.mapper;

import com.lengyan.lybbs.model.AdminUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
public interface AdminUserMapper extends BaseMapper<AdminUser> {

  @Select("select u.*, r.name as roleName from admin_user u left join role r on u.role_id = r.id")
  List<Map<String, Object>> selectAll();
}
