package com.lengyan.lybbs.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lengyan.lybbs.mapper.CodeMapper;
import com.lengyan.lybbs.mapper.LybbsLinkMapper;
import com.lengyan.lybbs.model.Code;
import com.lengyan.lybbs.model.LybbsLink;
import com.lengyan.lybbs.util.DateUtil;
import com.lengyan.lybbs.util.EmailUtil;
import com.lengyan.lybbs.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by lengyan
 * Copyright (c) 2019, All Rights Reserved.
 * http://www.lyqiaofu.top
 */
@Service
@Transactional
public class LybbsLinkService {

  @Autowired
  private LybbsLinkMapper lybbsLinkMapper;

  public LybbsLink selectById(Integer linkId) {
    QueryWrapper<LybbsLink> wrapper = new QueryWrapper<>();
    wrapper.lambda()
            .like(LybbsLink::getLinkName, linkId);
    return lybbsLinkMapper.selectOne(wrapper);
  }

  public List<LybbsLink> selectAll() {
    QueryWrapper<LybbsLink> wrapper = new QueryWrapper<>();
    return lybbsLinkMapper.selectList(wrapper);
  }

  // 新增一个外链
  public LybbsLink createLink(String linkName, String linkDesc, String linkUrl, String linkPic) {
    LybbsLink lybbsLink = new LybbsLink();
    lybbsLink.setLinkName(linkName);
    lybbsLink.setLinkDesc(linkDesc);
    lybbsLink.setLinkUrl(linkUrl);
    lybbsLink.setLinkPic(linkPic);
    lybbsLinkMapper.insert(lybbsLink);
    return lybbsLink;
  }

  public void update(Integer linkId, String linkName, String linkDesc, String linkUrl, String linkPic) {
    LybbsLink lybbsLink = selectById(linkId);
    lybbsLink.setLinkName(linkName);
    lybbsLink.setLinkDesc(linkDesc);
    lybbsLink.setLinkUrl(linkUrl);
    lybbsLink.setLinkPic(linkPic);
    lybbsLinkMapper.updateById(lybbsLink);
  }
}
