package com.online.college.service;

import com.online.college.core.share.dao.ShareChannelDao;
import com.online.college.core.share.domain.ShareChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 测试service
 *
 * @author shuzheng
 * @date 2016年7月6日 下午6:07:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:applicationContext.xml"
})
public class UserServiceTest {

    @Autowired
    private ShareChannelDao mShareChannelDao;

    @Test
    public void index() {
        mShareChannelDao.create(new ShareChannel("test", "123"));
    }

}
