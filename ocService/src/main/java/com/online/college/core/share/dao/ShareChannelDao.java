package com.online.college.core.share.dao;

import com.online.college.common.page.TailPage;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.share.domain.ShareCategory;
import com.online.college.core.share.domain.ShareChannel;

import java.util.List;

/**
 * Created by andy on 2017/10/18.
 */
public interface ShareChannelDao {
    ShareCategory getById(Long id);

    void create(ShareChannel channel);

    Integer getTotalItemsCount(AuthUser authUser);

    List<ShareChannel> queryPage(AuthUser authUser, TailPage<ShareChannel> page);

    void delete(ShareChannel channel);

    void update(ShareChannel channel);

}
