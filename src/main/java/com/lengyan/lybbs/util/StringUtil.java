package com.lengyan.lybbs.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lengyan.
 * Copyright (c) 2018, All Rights Reserved.
 * http://blog.ruzishici.top/
 */
public class StringUtil {

  // email正则
  public static final String emailRegex = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
  // url正则
  public static final String urlRegex = "^((https|http)?:\\/\\/)[^\\s]+";
  // 用户名正则
  public static final String usernameRegex = "[a-z0-9A-Z]{2,16}";
  // 密码正则
  public static final String passwordRegex = "[a-z0-9A-Z]{6,32}";
  // 生成随机字符串用到的字符数组
  private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
  // 生成随机长度的数字用到的数组
  private static final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  private static final Random random = new Random();

  public static boolean check(String text, String regex) {
    if (StringUtils.isEmpty(text)) {
      return false;
    } else {
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(text);
      return matcher.matches();
    }
  }

  /**
   * 随机指定长度的字符串
   *
   * @param length
   * @return
   */
  public static String randomString(int length) {
    StringBuilder sb = new StringBuilder();
    for (int loop = 0; loop < length; ++loop) {
      sb.append(hexDigits[random.nextInt(hexDigits.length)]);
    }
    return sb.toString();
  }

  /**
   * 随机指定长度的数字
   *
   * @param length
   * @return
   */
  public static String randomNumber(int length) {
    StringBuilder sb = new StringBuilder();
    for (int loop = 0; loop < length; ++loop) {
      sb.append(digits[random.nextInt(digits.length)]);
    }
    return sb.toString();
  }

  // 生成一个uuid
  public static String uuid() {
    return UUID.randomUUID().toString();
  }

  /**
   * 检测是否是用户accessToken
   */
  public static boolean isUUID(String accessToken) {
    if (StringUtils.isEmpty(accessToken)) {
      return false;
    } else {
      try {
        // noinspection ResultOfMethodCallIgnored
        UUID.fromString(accessToken);
        return true;
      } catch (Exception e) {
        return false;
      }
    }
  }

  // 格式化url参数部分返回map
  // params格式：a=1&b=2&c=3
  // 返回：{a: 1, b: 2, c: 3}
  public static Map<String, Object> formatParams(String params) {
    if (StringUtils.isEmpty(params)) return null;
    Map<String, Object> map = new HashMap<>();
    for (String s : params.split("&")) {
      String[] ss = s.split("=");
      map.put(ss[0], ss[1]);
    }
    return map;
  }
}
