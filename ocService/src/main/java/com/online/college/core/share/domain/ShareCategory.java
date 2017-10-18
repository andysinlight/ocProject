package com.online.college.core.share.domain;

import com.online.college.common.orm.BaseEntity;

/**
 * Created by andy on 2017/10/18.
 */
public class ShareCategory extends BaseEntity {
    private long channelId;
    private String category;
    private String categoryName;

    public ShareCategory() {
    }

    public ShareCategory(long channelId, String category, String categoryName) {
        this.channelId = channelId;
        this.category = category;
        this.categoryName = categoryName;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
