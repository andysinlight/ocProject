package com.online.college.core.share.service.impl;

import com.online.college.common.page.TailPage;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.share.dao.ShareChannelDao;
import com.online.college.core.share.domain.ShareCategory;
import com.online.college.core.share.domain.ShareChannel;
import com.online.college.core.share.service.IShareChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareChannelServiceImpl implements IShareChannelService {

    @Autowired
    ShareChannelDao dao;

    @Override
    public ShareCategory getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public void create(ShareChannel channel) {
        dao.create(channel);
    }

    @Override
    public Integer getTotalItemsCount(AuthUser authUser) {
        return dao.getTotalItemsCount(authUser);
    }

    @Override
    public List<ShareChannel> queryPage(AuthUser authUser, TailPage<ShareChannel> page) {
        return dao.queryPage(authUser,page);
    }

    @Override
    public void delete(ShareChannel channel) {
        dao.delete(channel);
    }

    @Override
    public void update(ShareChannel channel) {
        dao.update(channel);
    }
}
