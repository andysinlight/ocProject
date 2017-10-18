package com.online.college.service;

import com.online.college.common.web.SpringBeanFactory;
import com.online.college.core.share.dao.ShareChannelDao;
import junit.framework.TestCase;
import org.apache.log4j.Logger;


public class ShareChannelTest  extends TestCase {
	Logger log = Logger.getLogger(AppTest.class);

	public void testImages() {
		ShareChannelDao dao = (ShareChannelDao) SpringBeanFactory.getBean("ShareChannelDao");

		
	}
}

