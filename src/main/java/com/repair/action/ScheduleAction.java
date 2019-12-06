package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Offer;
import com.repair.dao.pojo.Schedule;
import com.repair.service.iservice.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class ScheduleAction {
    @Autowired
    IScheduleService scheduleService;

    @RequestMapping("schedulepage.do")
    public String SchedulePage(HttpServletRequest request) {
        String url = null;
        try {
            String currPage = request.getParameter("currentPage");
            //判断   第一次是设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }
            int currentPage = Integer.parseInt(currPage);
            PageBean<Schedule> pb = new PageBean<Schedule>();
            pb.setCurrentPage(currentPage);
            scheduleService.findAllByPage(pb);
            request.setAttribute("pageBean", pb);
            url = "schedule";
        } catch (NumberFormatException e) {
            url = "error";
        }
        return url;
    }

    @RequestMapping("schedulerouter.do")
    public String ScheduleRouter(@RequestParam("router") String router) {
        if ("schedule_select".equalsIgnoreCase(router)) {
            return "schedule_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("scheduleid.do")
    public String ScheduleFindById(HttpServletRequest request) {
        int schid = Integer.parseInt(request.getParameter("schid"));
        Schedule schedule = scheduleService.findById(schid);
        if (schedule != null) {
            request.setAttribute("scheduleList", Arrays.asList(schedule));
            return "schedule_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("scheduleemp.do")
    public String ScheduleFindByEmp(HttpServletRequest request) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        List<Schedule> scheduleList = scheduleService.findByEmp(empno);
        if (scheduleList != null && scheduleList.size() > 0) {
            request.setAttribute("scheduleList", scheduleList);
            return "schedule_select";
        } else {
            return "error";
        }
    }


}
