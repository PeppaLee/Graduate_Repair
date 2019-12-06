package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Component;
import com.repair.dao.pojo.Grade;
import com.repair.service.iservice.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeAction {
    @Autowired
    IGradeService gradeService;

    @RequestMapping("gradepage.do")
    public String GradePage(HttpServletRequest request) {
        String url = null;
        try {
            String currPage = request.getParameter("currentPage");
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }
            int currentPage = Integer.parseInt(currPage);
            PageBean<Grade> pb = new PageBean<Grade>();
            pb.setCurrentPage(currentPage);
            gradeService.findAllByPage(pb);
            request.setAttribute("pageBean", pb);
            url = "grade";
        } catch (NumberFormatException e) {
            url = "error";
        }
        return url;
    }

    @RequestMapping("graderouter.do")
    public String GradeRouter(@RequestParam("router") String router) {
        if ("grade_add".equalsIgnoreCase(router)) {
            return "grade_add";
        } else if ("grade_select".equalsIgnoreCase(router)) {
            return "grade_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("gradesave.do")
    public String GradeSave(HttpServletRequest request) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        String ename = request.getParameter("ename");
        int times = Integer.parseInt(request.getParameter("times"));
        int successtimes = Integer.parseInt(request.getParameter("successtimes"));
        String grade = request.getParameter("grade");

        Grade grade1 = new Grade(empno, ename, times, successtimes, grade);
        int i = gradeService.save(grade1);
        if (i > 0) {
            return "redirect:gradepage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("gradeupdate.do")
    public String GradeUpdate(HttpServletRequest request) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        String ename = request.getParameter("ename");
        int times = Integer.parseInt(request.getParameter("times"));
        int successtimes = Integer.parseInt(request.getParameter("successtimes"));
        String grade = request.getParameter("grade");

        Grade grade1 = new Grade(empno, ename, times, successtimes, grade);
        int i = gradeService.update(grade1);
        if (i > 0) {
            return "redirect:gradepage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("gradeid.do")
    public String GradeFindById(HttpServletRequest request) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        String type = request.getParameter("type");
        Grade grade = gradeService.findById(empno);
        if (grade != null) {
            if ("update".equalsIgnoreCase(type)) {
                request.setAttribute("grade", grade);
                return "grade_update";
            } else {
                request.setAttribute("gradeList", Arrays.asList(grade));
                return "grade_select";
            }
        } else {
            return "error";
        }
    }

    @RequestMapping("gradename.do")
    public String GradeFindByName(HttpServletRequest request) {
        String ename = request.getParameter("ename");
        List<Grade> gradeList = gradeService.findByName(ename);
        if (gradeList != null & gradeList.size() > 0) {
            request.setAttribute("gradeList", gradeList);
            return "grade_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("gradedelete.do")
    public String GradeDelete(HttpServletRequest request) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        int i = gradeService.delete(empno);
        if (i > 0) {
            return "redirect:gradepage.do";
        } else {
            return "error";
        }
    }
}
