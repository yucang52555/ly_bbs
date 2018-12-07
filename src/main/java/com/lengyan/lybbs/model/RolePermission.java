package com.lengyan.lybbs.model;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://blog.ruzishici.top
 */
public class RolePermission {

  private Integer roleId;
  private Integer permissionId;

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public Integer getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Integer permissionId) {
    this.permissionId = permissionId;
  }
}
