package com.online.college.opt.controller;

import com.online.college.common.page.TailPage;
import com.online.college.common.util.CalendarUtil;
import com.online.college.common.util.JsonUtil;
import com.online.college.common.web.JsonView;
import com.online.college.common.web.SessionContext;
import com.online.college.core.auth.domain.AuthUser;
import com.online.college.core.consts.domain.ConstsClassify;
import com.online.college.core.course.domain.Course;
import com.online.college.core.course.service.ICourseService;
import com.online.college.core.share.domain.ShareRecord;
import com.online.college.core.share.service.IShareRecordService;
import com.online.college.core.statics.domain.CourseStudyStaticsDto;
import com.online.college.core.statics.domain.StaticsVO;
import com.online.college.opt.business.IPortalBusiness;
import com.online.college.opt.vo.ConstsClassifyVO;
import com.online.college.opt.vo.CourseSectionVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/share")
public class ShareController {

    @Resource
    private ICourseService courseService;


    @Resource
    private ICourseService productService;


    @Autowired
    IShareRecordService shareRecordService;

    @Autowired
    private IPortalBusiness portalBusiness;


    /**
     * 课程管理
     */
    @RequestMapping("/pagelist")
    public ModelAndView list(Course queryEntity, TailPage<Course> page) {
        ModelAndView mv = new ModelAndView("cms/share/record");

        if (StringUtils.isNotEmpty(queryEntity.getName())) {
            queryEntity.setName(queryEntity.getName().trim());
        } else {
            queryEntity.setName(null);
        }
        page.setPageSize(6);
        page = courseService.queryPage(queryEntity, page);
        mv.addObject("page", page);
        mv.addObject("queryEntity", queryEntity);
        mv.addObject("curNav", "record");
        return mv;
    }


    /**
     * 课程详情
     */
    @RequestMapping("/read")
    public ModelAndView courseRead(Long id) {
        Course course = courseService.getById(id);
        if (null == course) {
            return new ModelAndView("error/404");
        }

        ModelAndView mv = new ModelAndView("cms/share/read");
        mv.addObject("curNav", "record");
        mv.addObject("course", course);


        Map<String, ConstsClassifyVO> classifyMap = portalBusiness.queryAllClassifyMap();
        //所有一级分类
        List<ConstsClassifyVO> classifysList = new ArrayList<ConstsClassifyVO>();
        for (ConstsClassifyVO vo : classifyMap.values()) {
            classifysList.add(vo);
        }
        mv.addObject("classifys", classifysList);

        List<ConstsClassify> subClassifys = new ArrayList<ConstsClassify>();
        for (ConstsClassifyVO vo : classifyMap.values()) {
            subClassifys.addAll(vo.getSubClassifyList());
        }
        mv.addObject("subClassifys", subClassifys);//所有二级分类

/*
        //课程章节
        List<CourseSectionVO> chaptSections = this.portalBusiness.queryCourseSection(id);
        mv.addObject("chaptSections", chaptSections);

        //课程分类
        Map<String,ConstsClassifyVO> classifyMap = portalBusiness.queryAllClassifyMap();
        //所有一级分类
        List<ConstsClassifyVO> classifysList = new ArrayList<ConstsClassifyVO>();
        for(ConstsClassifyVO vo : classifyMap.values()){
            classifysList.add(vo);
        }
        mv.addObject("classifys", classifysList);

        List<ConstsClassify> subClassifys = new ArrayList<ConstsClassify>();
        for(ConstsClassifyVO vo : classifyMap.values()){
            subClassifys.addAll(vo.getSubClassifyList());
        }
        mv.addObject("subClassifys", subClassifys);//所有二级分类

        //获取报表统计信息
        CourseStudyStaticsDto staticsDto = new CourseStudyStaticsDto();
        staticsDto.setCourseId(course.getId());
        staticsDto.setEndDate(new Date());
        staticsDto.setStartDate(CalendarUtil.getPreNDay(new Date(), 7));

        StaticsVO staticsVo = staticsService.queryCourseStudyStatistics(staticsDto);
        if(null != staticsVo){
            try {
                mv.addObject("staticsVo", JsonUtil.toJson(staticsVo));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        return mv;
    }


    @RequestMapping("/record")
    public ModelAndView getRecodes(TailPage<ShareRecord> page) {
        ModelAndView modelAndView;
        if (SessionContext.isLogin()) {
            AuthUser user = new AuthUser();
            user.setId(123l);
            page.setPageSize(3);
            page = shareRecordService.queryPage(user, page);
            modelAndView = new ModelAndView("cms/share/record");
            modelAndView.addObject("curNav", "record");
            modelAndView.addObject("page", page);

        } else {
            modelAndView = new ModelAndView("/error/404");
        }
        return modelAndView;
    }


    @RequestMapping("record/doDelete")
    @ResponseBody
    public String doDelete(ShareRecord entity) {
        shareRecordService.delete(entity);
        return new JsonView().toString();
    }


    @RequestMapping("record/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("cms/share/add");
        Map<String, ConstsClassifyVO> classifyMap = portalBusiness.queryAllClassifyMap();
        //所有一级分类
        List<ConstsClassifyVO> classifysList = new ArrayList<ConstsClassifyVO>();
        for (ConstsClassifyVO vo : classifyMap.values()) {
            classifysList.add(vo);
        }
        mv.addObject("classifys", classifysList);

        List<ConstsClassify> subClassifys = new ArrayList<ConstsClassify>();
        for (ConstsClassifyVO vo : classifyMap.values()) {
            subClassifys.addAll(vo.getSubClassifyList());
        }
        mv.addObject("subClassifys", subClassifys);//所有二级分类

        return mv;
    }


    @RequestMapping("/channel/index")
    public ModelAndView getChannels(TailPage<ShareRecord> page) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("cms/share/channelIndex");
        modelAndView.addObject("curNav", "channel");

        Map<String, ConstsClassifyVO> classifyMap = portalBusiness.queryAllClassifyMap();

        //所有一级分类
        List<ConstsClassifyVO> classifysList = new ArrayList<ConstsClassifyVO>();
        for (ConstsClassifyVO vo : classifyMap.values()) {
            classifysList.add(vo);
        }
        modelAndView.addObject("classifys", classifysList);

        List<ConstsClassify> subClassifys = new ArrayList<ConstsClassify>();
        for (ConstsClassifyVO vo : classifyMap.values()) {
            subClassifys.addAll(vo.getSubClassifyList());
        }
        modelAndView.addObject("subClassifys", subClassifys);//所有二级分类

        return modelAndView;
    }


    @RequestMapping("/item/doMerge")
    @ResponseBody
    public String doMerge(Course entity) {
        String key = null;
        if (null != entity.getId()) {
            productService.updateSelectivity(entity);
        } else {
            productService.createSelectivity(entity);
        }
        return JsonView.render(entity).toString();
    }

    //批量添加章节
    @RequestMapping(value = "/batchAdd")
    @ResponseBody
    public String batchAdd(@RequestBody List<ShareRecord> batchSections) {
        for (ShareRecord rcord :
                batchSections) {
            rcord.setuId(SessionContext.getUserId());

            shareRecordService.create(rcord);
        }
        return new JsonView().toString();
    }


    @RequestMapping(value = "/readRecord")
    @ResponseBody
    public String readRecord(Long id) {
        Course course = courseService.getById(id);
        List<ShareRecord> shareRecords = shareRecordService.queryAll(id);
        Map<String, Object> map = new HashMap<>();
        map.put("course", course);
        map.put("record", shareRecords);
        return JsonView.render(map);
    }

}
