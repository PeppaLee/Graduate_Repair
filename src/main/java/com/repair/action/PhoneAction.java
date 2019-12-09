package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Offer;
import com.repair.dao.pojo.Phone;
import com.repair.service.iservice.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class PhoneAction {
    @Autowired
    IPhoneService phoneService;

    @RequestMapping("phonepage.do")
    public String PhonePage(HttpServletRequest request) {
        String url = null;
        try {
            String currPage = request.getParameter("currentPage");
            //判断   第一次是设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }
            int currentPage = Integer.parseInt(currPage);
            PageBean<Phone> pb = new PageBean<Phone>();
            pb.setCurrentPage(currentPage);
            phoneService.findAllByPage(pb);
            request.setAttribute("pageBean", pb);
            url = "phone";
        } catch (NumberFormatException e) {
            url = "error";
        }
        return url;
    }

    @RequestMapping("phonerouter.do")
    public String PhoneRouter(@RequestParam("router") String router) {
        if ("phone_add".equalsIgnoreCase(router)) {
            return "phone_add";
        } else if ("phone_select".equalsIgnoreCase(router)) {
            return "phone_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("phonesave.do")
    public String PhoneSave(HttpServletRequest request) {
        String ptype = request.getParameter("ptype");
        String reason = request.getParameter("reason");

        Phone phone = new Phone(ptype,reason);
        int i = phoneService.save(phone);
        if (i > 0) {
            return "redirect:phonepage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("phoneupdate.do")
    public String PhoneUpdate(HttpServletRequest request) {
        int phoneid = Integer.parseInt(request.getParameter("phoneid"));
        String ptype = request.getParameter("ptype");
        String reason = request.getParameter("reason");

        Phone phone = new Phone(phoneid,ptype,reason);
        int i = phoneService.update(phone);
        if (i > 0) {
            return "redirect:phonepage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("phoneid.do")
    public String PhoneFindById(HttpServletRequest request) {
        String type = request.getParameter("type");
        int phoneid = Integer.parseInt(request.getParameter("phoneid"));
        Phone phone = phoneService.findById(phoneid);
        if (phone != null) {
            if ("update".equalsIgnoreCase(type)) {
                request.setAttribute("phone", phone);
                return "phone_update";
            } else {
                request.setAttribute("phoneList", Arrays.asList(phone));
                return "phone_select";
            }
        } else {
            return "phone_select_error";
        }
    }

    @RequestMapping("phonetype.do")
    public String PhoneFindByType(HttpServletRequest request) {
        String ptype = request.getParameter("ptype");
        List<Phone> phoneList = phoneService.findByName(ptype);
        if (phoneList != null && phoneList.size() > 0) {
            request.setAttribute("phoneList", phoneList);
            return "phone_select";
        } else {
            return "phone_select_error";
        }
    }

    @RequestMapping("phonedelete.do")
    public String PhoneDelete(HttpServletRequest request) {
        int phoneid = Integer.parseInt(request.getParameter("phoneid"));
        int i =phoneService.delete(phoneid);
        if (i > 0) {
            return "redirect:phonepage.do";
        } else {
            return "error";
        }
    }
}
