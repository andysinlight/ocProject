package com.online.college.service;

import com.online.college.common.page.TailPage;
import com.online.college.common.web.SpringBeanFactory;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.share.dao.ShareRecordDao;
import com.online.college.core.share.domain.ShareCategory;
import com.online.college.core.share.domain.ShareChannel;
import com.online.college.core.share.domain.ShareRecord;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2017/10/18.
 */
public class ShareRecordTest extends TestCase {

    public void testCreate() {
        ShareRecordDao shareRecordDao = (ShareRecordDao) SpringBeanFactory.getBean("shareRecordDao");

        ShareRecord record = new ShareRecord();
        record.setuId(123l);
        record.setTitle("test_record");
        record.setName("info");
        record.setShareChannel("12");
        record.setShareChannelName("测试");
        record.setShareCategory("222");
        record.setShareCategoryName("heh");
        record.setShareItemId(110l);
        record.setShareOrder("adsf");
        record.setShareOrderStrategyName("随机");
        shareRecordDao.create(record);

        shareRecordDao.create(record);
    }

    public void testGetItem() {
        ShareRecordDao shareRecordDao = (ShareRecordDao) SpringBeanFactory.getBean("shareRecordDao");
        ShareRecord byId = shareRecordDao.getById(1l);
        byId.setTitle("update");
        shareRecordDao.update(byId);
    }

    public void testQuery() {
        ShareRecordDao shareRecordDao = (ShareRecordDao) SpringBeanFactory.getBean("shareRecordDao");
        AuthUser user = new AuthUser();
        user.setId(123l);
        TailPage<ShareRecord> page = new TailPage<>(1, 2, shareRecordDao.getTotalItemsCount(user), new ArrayList<ShareRecord>());
    }


}
