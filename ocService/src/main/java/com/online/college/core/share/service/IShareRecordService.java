package com.online.college.core.share.service;

import com.online.college.common.page.TailPage;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.share.domain.ShareChannel;
import com.online.college.core.share.domain.ShareRecord;

import java.util.List;

public interface IShareRecordService {

    ShareRecord getById(Long id);

    void create(ShareRecord record);

    Integer getTotalItemsCount(AuthUser authUser);

    List<ShareRecord> queryAll(Long id);


    TailPage<ShareRecord> queryPage(AuthUser authUser, TailPage<ShareRecord> page);

    void delete(ShareRecord record);

    void update(ShareRecord record);

}
