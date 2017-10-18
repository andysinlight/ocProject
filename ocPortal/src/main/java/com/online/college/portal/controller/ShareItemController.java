package com.online.college.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/share")
public class ShareItemController {

    @RequestMapping("/item/{itemId}")
    public ModelAndView learn(@PathVariable Long itemId){
        if(null == itemId)
            return new ModelAndView("error/404");
//        Course course = courseService.getById(courseId);
        ModelAndView mv = new ModelAndView("share");

        mv.addObject("itemInfo", "http://www.baidu.com");
        return mv;
    }


}
