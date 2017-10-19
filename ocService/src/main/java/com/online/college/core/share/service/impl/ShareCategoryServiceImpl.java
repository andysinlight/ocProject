package com.online.college.core.share.service.impl;

import com.online.college.common.page.TailPage;
import com.online.college.core.share.dao.ShareCategoryDao;
import com.online.college.core.share.domain.ShareCategory;
import com.online.college.core.share.domain.ShareChannel;
import com.online.college.core.share.service.IShareCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareCategoryServiceImpl implements IShareCategoryService {

    @Autowired
    ShareCategoryDao dao;

    @Override
    public ShareCategory getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public void create(ShareCategory category) {
        dao.create(category);
    }

    @Override
    public Integer getTotalItemsCount(ShareChannel channel) {
        return dao.getTotalItemsCount(channel);
    }

    @Override
    public List<ShareCategory> queryPage(ShareChannel channel, TailPage<ShareCategory> page) {
        return dao.queryPage(channel,page);
    }

    @Override
    public void delete(ShareCategory category) {
        dao.delete(category);
    }

    @Override
    public void update(ShareCategory category) {
        dao.update(category);
    }
}
