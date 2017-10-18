package com.online.college.core.share.domain;

import com.online.college.common.orm.BaseEntity;

/**
 * Created by andy on 2017/10/18.
 */
public class ShareRecord extends BaseEntity {
    private long uId;
    private long shareItemId;
    private String title;
    private String name;
    private String shareChannelName;
    private String shareChannel;
    private String shareCategoryName;
    private String shareCategory;
    private String shareOrder;
    private String shareOrderStrategyName;
    private int shareOrderStrategy;
    private long shareCount;

    public ShareRecord() {
    }

    public ShareRecord(long shareItemId, String title, String name, String shareChannelName, String shareChannel, String shareCategoryName, String shareCategory, String shareOrder, String shareOrderStrategyName, int shareOrderStrategy) {
        this.shareItemId = shareItemId;
        this.title = title;
        this.name = name;
        this.shareChannelName = shareChannelName;
        this.shareChannel = shareChannel;
        this.shareCategoryName = shareCategoryName;
        this.shareCategory = shareCategory;
        this.shareOrder = shareOrder;
        this.shareOrderStrategyName = shareOrderStrategyName;
        this.shareOrderStrategy = shareOrderStrategy;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public long getShareItemId() {
        return shareItemId;
    }

    public void setShareItemId(long shareItemId) {
        this.shareItemId = shareItemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShareChannel() {
        return shareChannel;
    }

    public void setShareChannel(String shareChannel) {
        this.shareChannel = shareChannel;
    }

    public String getShareCategory() {
        return shareCategory;
    }

    public void setShareCategory(String shareCategory) {
        this.shareCategory = shareCategory;
    }

    public String getShareOrder() {
        return shareOrder;
    }

    public void setShareOrder(String shareOrder) {
        this.shareOrder = shareOrder;
    }

    public int getShareOrderStrategy() {
        return shareOrderStrategy;
    }

    public void setShareOrderStrategy(int shareOrderStrategy) {
        this.shareOrderStrategy = shareOrderStrategy;
    }

    public String getShareChannelName() {
        return shareChannelName;
    }

    public void setShareChannelName(String shareChannelName) {
        this.shareChannelName = shareChannelName;
    }

    public String getShareCategoryName() {
        return shareCategoryName;
    }

    public void setShareCategoryName(String shareCategoryName) {
        this.shareCategoryName = shareCategoryName;
    }

    public String getShareOrderStrategyName() {
        return shareOrderStrategyName;
    }

    public void setShareOrderStrategyName(String shareOrderStrategyName) {
        this.shareOrderStrategyName = shareOrderStrategyName;
    }

    public long getShareCount() {
        return shareCount;
    }

    public void setShareCount(long shareCount) {
        this.shareCount = shareCount;
    }
}
