package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Grade;
import com.repair.dao.pojo.Login;
import com.repair.service.iservice.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginAction {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String Login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "pri") Integer pri,
                        HttpServletRequest request) {
        Login login = loginService.login(username, password);
//        HttpSession session1 = request.getSession();
//        HttpSession session2 = request.getSession();
        HttpSession session3 = request.getSession();
        if (login != null) {
            if (pri == login.getPri() && pri == 1) {
//                session1.setAttribute("loginid", login.getUserid());
//                session2.setAttribute("login",login);
                return "index";
            } else if (pri == login.getPri() && pri == 2) {
//                session1.setAttribute("loginid", login.getUserid());
//                session2.setAttribute("login",login);
                session3.setAttribute("empno",login.getEmpno());
                return "weixiu";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }
//    @RequestMapping(value = "login.do", method = RequestMethod.POST)
//    public String Login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        HttpServletRequest request) {
//        Login login = loginService.login(username, password);
//        HttpSession session = request.getSession();
//        if (login != null) {
//            session.setAttribute("login", login);
//            return "index";
//        } else {
//            return "error";
//        }
//    }

    @RequestMapping("loginpage.do")
    public String LoginPage(HttpServletRequest request) {
        String url = null;
        try {
            String currPage = request.getParameter("currentPage");
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }
            int currentPage = Integer.parseInt(currPage);
            PageBean<Login> pb = new PageBean<Login>();
            pb.setCurrentPage(currentPage);
            loginService.findAllByPage(pb);
            request.setAttribute("pageBean", pb);
            url = "loginer";
        } catch (NumberFormatException e) {
            url = "error";
        }
        return url;
    }

    @RequestMapping("loginrouter.do")
    public String LoginRouter(@RequestParam("router") String router) {
        if ("login_add".equalsIgnoreCase(router)) {
            return "login_add";
        } else if ("login_select".equalsIgnoreCase(router)) {
            return "login_select";
        } else if ("adminpwd".equalsIgnoreCase(router)){
            return "adminpwd";
        }else {
            return "error";
        }
    }

    @RequestMapping("loginsave.do")
    public String LoginSave(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int pri = Integer.parseInt(request.getParameter("pri"));
        Login login1 = loginService.findExist(username);
        if (login1 == null) {
            Login login = new Login(username, password, pri);
            int i = loginService.save(login);
            if (i > 0) {
                return "redirect:loginpage.do";
            } else {
                return "error";
            }
        } else {
            return "error";
        }


    }

    @RequestMapping("logindelete.do")
    public String LoginDelete(HttpServletRequest request) {
        int userid = Integer.parseInt(request.getParameter("userid"));
        int i = loginService.delete(userid);
        if (i > 0) {
            return "redirect:loginpage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("loginupdate.do")
    public String LoginUpdate(HttpServletRequest request) {
        int userid = Integer.parseInt(request.getParameter("userid"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int pri = Integer.parseInt(request.getParameter("pri"));

        Login login = new Login(userid, username, password, pri);
        int i = loginService.update(login);
        if (i > 0) {
            return "redirect:loginpage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("updatepwd.do")
    public String UpdatePassword(HttpServletRequest request){
        int userid = (int) request.getSession().getAttribute("loginid");
        String password = request.getParameter("newpass");
        System.err.println(userid);
        Login login = new Login(userid,password);
        int i = loginService.updatePassword(login);
        if (i > 0){
            return "redirect:loginpage.do";
        }else {
            return "error";
        }
    }

    @RequestMapping("loginname.do")
    public String LoginFindByName(HttpServletRequest request) {
        String username = request.getParameter("username");
        List<Login> loginList = loginService.fingdByName(username);
        if (loginList != null && loginList.size() > 0) {
            request.setAttribute("loginList", loginList);
            return "login_select";
        } else {
            return "error";
        }
    }
}
