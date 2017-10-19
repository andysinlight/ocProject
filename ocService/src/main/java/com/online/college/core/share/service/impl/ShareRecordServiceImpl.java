package com.online.college.core.share.service.impl;

import com.online.college.common.page.TailPage;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.share.dao.ShareRecordDao;
import com.online.college.core.share.domain.ShareChannel;
import com.online.college.core.share.domain.ShareRecord;
import com.online.college.core.share.service.IShareRecordService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareRecordServiceImpl implements IShareRecordService {
    @Autowired
    ShareRecordDao dao;

    @Override
    public ShareRecord getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public void create(ShareRecord record) {
        dao.create(record);
    }

    @Override
    public Integer getTotalItemsCount(AuthUser authUser) {
        return dao.getTotalItemsCount(authUser);
    }

    @Override
    public TailPage<ShareRecord> queryPage(AuthUser authUser, TailPage<ShareRecord> page) {

        Integer itemsTotalCount = dao.getTotalItemsCount(authUser);
        List<ShareRecord> items = dao.queryPage(authUser,page);
        /*if(CollectionUtils.isNotEmpty(items)){
            for(ShareRecord item : items){
                prepareCoursePicture(item);
            }
        }*/
        page.setItemsTotalCount(itemsTotalCount);
        page.setItems(items);
        return page;
    }

    @Override
    public void delete(ShareRecord record) {
        dao.delete(record);
    }

    @Override
    public void update(ShareRecord record) {
        dao.update(record);
    }
}
