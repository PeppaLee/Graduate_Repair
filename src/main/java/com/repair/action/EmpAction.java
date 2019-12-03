package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Emp;
import com.repair.service.iservice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Controller
public class EmpAction {
    @Autowired
    IEmpService empService;

    @RequestMapping("emppage.do")
    public String EmpPage(HttpServletRequest request, HttpServletResponse response) {
        String url = null;
        try {
            String currPage = request.getParameter("currentPage");
            //判断   第一次是设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }
            int currentPage = Integer.parseInt(currPage);

            PageBean<Emp> pb = new PageBean<Emp>();
            pb.setCurrentPage(currentPage);

            empService.findAllByPage(pb);

            request.setAttribute("pageBean", pb);

            url = "emp";
        } catch (NumberFormatException e) {
            url = "error";
        }
        return url;
    }

    @RequestMapping("empsave.do")
    public String EmpSave(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ename = request.getParameter("ename");
        String gender = request.getParameter("gender");
        String grade = request.getParameter("gender");
        BigDecimal sal = new BigDecimal(request.getParameter("sal"));
        String hiredate = request.getParameter("hiredate");
        int partid = Integer.parseInt(request.getParameter("partid"));

        Emp emp = new Emp(ename, gender, grade, sal, sdf.parse(hiredate), partid);
        int i = empService.save(emp);
        if (i > 0) {
            return "redirect:emppage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("router.do")
    public String Router(@RequestParam(value = "router") String router) {
        if ("emp_add".equals(router)) {
            return "emp_add";
        } else if ("emp_select".equalsIgnoreCase(router)) {
            return "emp_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("empupdate.do")
    public String EmpUpdate(HttpServletRequest request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int empno = Integer.parseInt(request.getParameter("empno"));
        String ename = request.getParameter("ename");
        String gender = request.getParameter("gender");
        String grade = request.getParameter("grade");
        BigDecimal sal = new BigDecimal(request.getParameter("sal"));
        String hiredate = request.getParameter("hiredate");
        int partid = Integer.parseInt(request.getParameter("partid"));

        Emp emp = new Emp(empno, ename, gender, grade, sal, sdf.parse(hiredate), partid);
        int i = empService.update(emp);
        if (i > 0) {
            return "redirect:emppage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("empid.do")
    public String EmpFindById(HttpServletRequest request) {
        String type = request.getParameter("type");
        int empno = Integer.parseInt(request.getParameter("empno"));
        Emp emp = empService.findById(empno);
        if (emp != null) {
            if ("update".equalsIgnoreCase(type)) {
                request.setAttribute("emp", emp);
                return "emp_update";
            } else {
                request.setAttribute("empList", Arrays.asList(emp));
                return "emp_select";
            }
        } else {
            return "error";
        }
    }

    @RequestMapping("empname.do")
    public String EmpFindByName(HttpServletRequest request) {
        String ename = request.getParameter("ename");
        List<Emp> empList = empService.findByName(ename);
        if (empList != null && empList.size() > 0) {
            request.setAttribute("empList", empList);
            return "emp_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("empdelete.do")
    public String EmpDelete(HttpServletRequest request) {
        int empno = Integer.parseInt(request.getParameter("empno"));

        int i = empService.delete(empno);
        if (i>0){
            return "redirect:emppage.do";
        }else {
            return "error";
        }
    }
}
