package com.online.college.service;

import com.online.college.common.page.TailPage;
import com.online.college.common.web.SpringBeanFactory;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.share.dao.ShareCategoryDao;
import com.online.college.core.share.dao.ShareChannelDao;
import com.online.college.core.share.domain.ShareCategory;
import com.online.college.core.share.domain.ShareChannel;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2017/10/18.
 */
public class ChannelCategoryTest extends TestCase {
    
    public void testCreate(){
        ShareCategoryDao dao = (ShareCategoryDao) SpringBeanFactory.getBean("shareCategoryDao");

        ShareChannelDao mShareChannelDao = (ShareChannelDao) SpringBeanFactory.getBean("shareChannelDao");
        AuthUser authUser = new AuthUser();
        authUser.setId(123l);
        List<ShareChannel> shareChannels = mShareChannelDao.queryPage(authUser, new TailPage<ShareChannel>(1, 5, mShareChannelDao.getTotalItemsCount(authUser), new ArrayList<ShareChannel>()));

        for (ShareChannel channel:
             shareChannels) {
            dao.create(new ShareCategory(channel.getId(),"test","test"));
        }
        dao.create(new ShareCategory());
    }

    public void testQuery(){
        ShareCategoryDao dao = (ShareCategoryDao) SpringBeanFactory.getBean("shareCategoryDao");

        ShareChannel channel = new ShareChannel("","");
        channel.setId(1l);
        TailPage<ShareCategory> page = new TailPage<>(1, 10, dao.getTotalItemsCount(channel), new ArrayList<ShareCategory>());
        List<ShareCategory> shareCategories = dao.queryPage(channel, page);
        shareCategories.size();
    }

    public void testUpdate(){
        ShareCategoryDao dao = (ShareCategoryDao) SpringBeanFactory.getBean("shareCategoryDao");
        ShareCategory category = dao.getById(1l);

        category.setCategoryName("updated");
        dao.update(category);
    }

    
}
