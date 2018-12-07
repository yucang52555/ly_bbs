package com.lengyan.lybbs.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lengyan.lybbs.mapper.RolePermissionMapper;
import com.lengyan.lybbs.model.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lengyan.
 * Copyright (c) 2018, All Rights Reserved.
 * http://blog.ruzishici.top/
 */
@Service
@Transactional
public class RolePermissionService {

  @Autowired
  private RolePermissionMapper rolePermissionMapper;

  // 根据角色id查询所有的角色权限关联记录
  public List<RolePermission> selectByRoleId(Integer roleId) {
    QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
    wrapper.lambda()
        .eq(RolePermission::getRoleId, roleId);
    return rolePermissionMapper.selectList(wrapper);
  }

  // 根据角色id删除关联关系
  public void deleteByRoleId(Integer roleId) {
    QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
    wrapper.lambda()
        .eq(RolePermission::getRoleId, roleId);
    rolePermissionMapper.delete(wrapper);
  }

  // 根据权限id删除关联关系
  public void deleteByPermissionId(Integer permissionId) {
    QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
    wrapper.lambda()
        .eq(RolePermission::getPermissionId, permissionId);
    rolePermissionMapper.delete(wrapper);
  }

  public void insert(RolePermission rolePermission) {
    rolePermissionMapper.insert(rolePermission);
  }

}
