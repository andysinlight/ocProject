package com.online.college.core.share.dao;

import com.online.college.common.page.TailPage;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.course.domain.CourseSection;
import com.online.college.core.share.domain.ShareCategory;
import com.online.college.core.share.domain.ShareChannel;
import com.online.college.core.share.domain.ShareRecord;

import java.util.List;

/**
 * Created by andy on 2017/10/18.
 */
public interface ShareRecordDao {

    ShareRecord getById(Long id);

    void create(ShareRecord record);

    Integer getTotalItemsCount(AuthUser authUser);

    List<ShareRecord> queryAll(Long id);


    List<ShareRecord> queryPage(AuthUser authUser, TailPage<ShareRecord> page);

    void delete(ShareRecord record);

    void update(ShareRecord record);

}
