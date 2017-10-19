package com.online.college.core.share.service;

import com.online.college.common.page.TailPage;
import com.online.college.core.share.domain.ShareCategory;
import com.online.college.core.share.domain.ShareChannel;

import java.util.List;

public interface IShareCategoryService {
    public ShareCategory getById(Long id);

    void create(ShareCategory category);

    Integer getTotalItemsCount(ShareChannel channel);

    List<ShareCategory> queryPage(ShareChannel channel, TailPage<ShareCategory> page);

    void delete(ShareCategory category);

    void update(ShareCategory category);
}
