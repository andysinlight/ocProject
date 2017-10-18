package com.online.college.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.online.college.common.page.TailPage;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.share.dao.ShareChannelDao;
import com.online.college.core.share.domain.ShareChannel;
import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.online.college.common.web.SpringBeanFactory;
import com.online.college.test.dao.TestDao;

public class AppTest extends TestCase {
    Logger log = Logger.getLogger(AppTest.class);

    public void testApp() {
        TestDao testDao = (TestDao) SpringBeanFactory.getBean("testDao");
        Map<String, Object> map = testDao.testQuery();
        log.info("### curDate = " + map.get("curdate"));
        ShareChannelDao mShareChannelDao = (ShareChannelDao) SpringBeanFactory.getBean("shareChannelDao");
        ShareChannel test = new ShareChannel("test", "123");
        test.setuId(123);
        mShareChannelDao.create(test);

    }

    public void testChannel() {
        ShareChannelDao mShareChannelDao = (ShareChannelDao) SpringBeanFactory.getBean("shareChannelDao");
        AuthUser authUser = new AuthUser();
        authUser.setId(123l);
        Integer totalItemsCount = mShareChannelDao.getTotalItemsCount(authUser);
        List<ShareChannel> shareChannels = mShareChannelDao.queryPage(authUser, new TailPage<ShareChannel>(1, 5, totalItemsCount, new ArrayList<ShareChannel>()));
        shareChannels.get(0);
    }

    public void testdeletaChannel() {
        ShareChannelDao mShareChannelDao = (ShareChannelDao) SpringBeanFactory.getBean("shareChannelDao");
        ShareChannel channel = new ShareChannel("", "");
        channel.setId(1l);
        mShareChannelDao.delete(channel);
    }

    public void testUpdateChannel() {
        ShareChannelDao mShareChannelDao = (ShareChannelDao) SpringBeanFactory.getBean("shareChannelDao");
        ShareChannel channel = new ShareChannel("", "");
        channel.setuId(123l);
        channel.setId(1l);
        mShareChannelDao.update(channel);
    }

}
