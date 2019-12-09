package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Login;
import com.repair.dao.pojo.Offer;
import com.repair.dao.pojo.Schedule;
import com.repair.service.iservice.ILoginService;
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

    @Autowired
    ILoginService loginService;

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
        } else if ("emp_schedule_select".equalsIgnoreCase(router)) {
            return "emp_schedule_select";
        } else if ("emppwd".equalsIgnoreCase(router)) {
            return "emppwd";
        } else if ("schedule_add".equalsIgnoreCase(router)) {
            return "schedule_add";
        } else if ("schedule_update".equalsIgnoreCase(router)) {
            return "schedule_update";
        } else {
            return "error";
        }
    }

    @RequestMapping("schedulesave.do")
    public String ScheduleSave(HttpServletRequest request) {
        int empno = (int) request.getSession().getAttribute("empno");
        int phoneid = Integer.parseInt(request.getParameter("phoneid"));
        String repairschedule = request.getParameter("repairschedule");
        String expectresult = request.getParameter("expectresult");
        String declares = request.getParameter("declares");

        Schedule schedule = new Schedule(empno, phoneid, repairschedule, expectresult, declares);
        int i = scheduleService.save(schedule);
        if (i > 0) {
            return "redirect:scheduleself.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("scheduleid.do")
    public String ScheduleFindById(HttpServletRequest request) {
        String type = request.getParameter("type");
        int schid = Integer.parseInt(request.getParameter("schid"));
        Schedule schedule = scheduleService.findById(schid);
        if (schedule != null) {
            if ("update".equalsIgnoreCase(type)) {
                request.setAttribute("schedule", schedule);
                return "schedule_update";
            } else {
                request.setAttribute("scheduleList", Arrays.asList(schedule));
                return "schedule_select";
            }
        } else {
            return "schedule_select_error";
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
            return "schedule_select_error";
        }
    }

    @RequestMapping("scheduleself.do")
    public String ScheduleSelf(HttpServletRequest request) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        System.err.println(empno);
//        int empno = (int) request.getSession().getAttribute("empno");
//        Login login = (Login) request.getSession().getAttribute("login");
        List<Schedule> scheduleList = scheduleService.findSelf(empno);
        if (scheduleList != null && scheduleList.size() > 0) {
            request.setAttribute("scheduleList", scheduleList);
            return "emp_schedule_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("empupdatepwd.do")
    public String UpdatePassword(HttpServletRequest request) {
        int userid = (int) request.getSession().getAttribute("loginid");
        String password = request.getParameter("newpass");
        System.err.println(userid);
        Login login = new Login(userid, password);
        int i = loginService.updatePassword(login);
        if (i > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("scheduleupdate.do")
    public String ScheduleUpdate(HttpServletRequest request) {
        int schid = Integer.parseInt(request.getParameter("schid"));
        int empno = (int) request.getSession().getAttribute("empno");
        int phoneid = Integer.parseInt(request.getParameter("phoneid"));
        String repairschdeule = request.getParameter("repairschdeule");
        String expectresult = request.getParameter("expectresult");
        String declares = request.getParameter("declares");

        Schedule schedule = new Schedule(schid,empno, phoneid, repairschdeule, expectresult, declares);
        int i = scheduleService.update(schedule);
        if (i > 0) {
            return "redirect:scheduleself.do";
        } else {
            return "error";
        }
    }
}

