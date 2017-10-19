package com.online.college.core.share.service;

import com.online.college.common.page.TailPage;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.share.domain.ShareCategory;
import com.online.college.core.share.domain.ShareChannel;

import java.util.List;

public interface IShareChannelService {

    ShareCategory getById(Long id);

    void create(ShareChannel channel);

    Integer getTotalItemsCount(AuthUser authUser);

    List<ShareChannel> queryPage(AuthUser authUser, TailPage<ShareChannel> page);

    void delete(ShareChannel channel);

    void update(ShareChannel channel);
}
