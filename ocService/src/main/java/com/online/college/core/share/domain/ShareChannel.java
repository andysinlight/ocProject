package com.online.college.core.share.domain;

import com.online.college.common.orm.BaseEntity;

/**
 * Created by andy on 2017/10/18.
 */
public class ShareChannel extends BaseEntity{
    private long uId;
    private String shareChannelName;
    private String channel;

    public ShareChannel() {
    }

    public ShareChannel(String shareChannelName, String channel) {
        this.shareChannelName = shareChannelName;
        this.channel = channel;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public String getShareChannelName() {
        return shareChannelName;
    }

    public void setShareChannelName(String shareChannelName) {
        this.shareChannelName = shareChannelName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
