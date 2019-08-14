package com.lengyan.lybbs.util.identicon.generator;

import java.awt.*;

/**
 * Created by lengyan
 * Copyright (c) 2018, All Rights Reserved.
 * http://www.lyqiaofu.top/
 */
public interface IBaseGenartor {
  /**
   * 将hash字符串转换为bool二维6*5数组
   *
   * @param hash
   * @return
   */
  public boolean[][] getBooleanValueArray(String hash);


  /**
   * 获取图片背景色
   *
   * @return
   */
  public Color getBackgroundColor();


  /**
   * 获取图案前景色
   *
   * @return
   */
  public Color getForegroundColor();
}
