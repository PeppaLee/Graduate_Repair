package com.repair.action;

import com.repair.dao.pojo.Login;
import com.repair.service.iservice.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginAction {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String Login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "pri") Integer pri) {
        Login login = loginService.login(username, password);
        if (login != null) {
            if (pri == login.getPri() && pri == 1) {
                return "index";
            } else if (pri == login.getPri() && pri == 2) {
                return "1111";
            }else {
                return "error";
            }
        } else {
            return "error";
        }
    }

}
