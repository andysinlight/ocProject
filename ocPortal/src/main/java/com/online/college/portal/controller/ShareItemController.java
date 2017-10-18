package com.online.college.portal.controller;

import com.online.college.common.storage.QiniuStorage;
import com.online.college.common.web.SessionContext;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.course.domain.Course;
import com.online.college.core.course.domain.CourseQueryDto;
import com.online.college.core.course.domain.CourseSection;
import com.online.college.core.user.domain.UserCourseSection;
import com.online.college.portal.vo.CourseSectionVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/share")
public class ShareItemController {


    @RequestMapping("/item/{itemId}")
    public ModelAndView learn(@PathVariable Long itemId){
        if(null == itemId)
            return new ModelAndView("error/404");
//        Course course = courseService.getById(courseId);
        ModelAndView mv = new ModelAndView("share");

        mv.addObject("itemInfo", "www.baidu.com");
        return mv;
    }


}
