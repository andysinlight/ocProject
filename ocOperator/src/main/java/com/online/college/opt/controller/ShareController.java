package com.online.college.opt.controller;

import com.online.college.common.page.TailPage;
import com.online.college.common.web.JsonView;
import com.online.college.common.web.SessionContext;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.consts.domain.ConstsClassify;
import com.online.college.core.course.domain.Course;
import com.online.college.core.share.domain.ShareRecord;
import com.online.college.core.share.service.IShareRecordService;
import com.online.college.opt.vo.ConstsClassifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/share")
public class ShareController {

    @Autowired
    IShareRecordService shareRecordService;

    @RequestMapping("/record")
    public ModelAndView getRecodes(TailPage<ShareRecord> page) {
        ModelAndView modelAndView;
        if (SessionContext.isLogin()) {
            AuthUser user = new AuthUser();
            user.setId(123l);
            page.setPageSize(3);
            page = shareRecordService.queryPage(user, page);
            modelAndView = new ModelAndView("cms/share/record");
            modelAndView.addObject("page", page);

        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;
    }


    @RequestMapping("record/doDelete")
    @ResponseBody
    public String doDelete(ShareRecord entity){
        shareRecordService.delete(entity);
        return new JsonView().toString();
    }


    @RequestMapping("record/add")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView("cms/share/add");
        return mv;
    }




    @RequestMapping("/channel/index")
    public ModelAndView getChannels(TailPage<ShareRecord> page) {
        ModelAndView modelAndView;
        /*if (SessionContext.isLogin()) {
            AuthUser user = new AuthUser();
            user.setId(123l);
            page.setPageSize(3);
            page = shareRecordService.queryPage(user, page);
            modelAndView = new ModelAndView("cms/share/record");
            modelAndView.addObject("page", page);

        } else {
            modelAndView = new ModelAndView("/error/404");
        }*/
        modelAndView = new ModelAndView("cms/share/channelIndex");

        return modelAndView;
    }

}
