package com.lengyan.lybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lengyan
 * Copyright (c) 2019, All Rights Reserved.
 * http://www.lyqiaofu.top/
 */
public class LybbsLink implements Serializable {

    private static final long serialVersionUID = 7641334280087632506L;

    @TableId(type = IdType.AUTO)
    private Integer linkId;
    //链接描述
    private String linkDesc;
    //链接名称
    private String linkName;
    //链接图片
    private String linkPic;
    //链接url
    private String linkUrl;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLinkDesc() {
        return linkDesc;
    }

    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkPic() {
        return linkPic;
    }

    public void setLinkPic(String linkPic) {
        this.linkPic = linkPic;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
