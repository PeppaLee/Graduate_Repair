package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Component;
import com.repair.service.iservice.IComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class ComponentAction {

    @Autowired
    IComponentService componentService;

    @RequestMapping("componentPage.do")
    public String ConponentPage(HttpServletRequest request) {
        String url = null;
        try {
            String currPage = request.getParameter("currentPage");
            //判断   第一次是设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }
            int currentPage = Integer.parseInt(currPage);
            PageBean<Component> pb = new PageBean<Component>();
            pb.setCurrentPage(currentPage);
            componentService.findAllByPage(pb);
            request.setAttribute("pageBean", pb);
            url = "component";
        } catch (NumberFormatException e) {
            url = "error";
        }
        return url;
    }

    @RequestMapping("componentrouter.do")
    public String ComponentRouter(@RequestParam("router") String router) {
        if ("component_add".equals(router)) {
            return "component_add";
        } else if ("component_select".equalsIgnoreCase(router)) {
            return "component_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("componentid.do")
    public String ComponentId(HttpServletRequest request) {
        String type = request.getParameter("type");
        int cid = Integer.parseInt(request.getParameter("cid"));
        Component component = componentService.findById(cid);
        if (component != null) {
            if ("update".equalsIgnoreCase(type)) {
                request.setAttribute("component", component);
                return "component_update";
            } else {
                request.setAttribute("componentList", Arrays.asList(component));
                return "component_select";
            }
        } else {
            return "component_select_error";
        }
    }

    @RequestMapping("componentname.do")
    public String ComponentName(HttpServletRequest request) {
        String cname = request.getParameter("cname");
        List<Component> componentList = componentService.findByName(cname);
        if (componentList != null && componentList.size() > 0) {
            request.setAttribute("componentList", componentList);
            return "component_select";
        } else {
            return "component_select_error";
        }
    }

    @RequestMapping("componentsave.do")
    public String ComponentSave(HttpServletRequest request) {
        String cname = request.getParameter("cname");
        BigDecimal cprice = new BigDecimal(request.getParameter("cprice"));
        Integer inventory = Integer.parseInt(request.getParameter("inventory"));

        Component component = new Component(cname,cprice,inventory);
        int i = componentService.save(component);
        if (i>0){
            return "redirect:componentPage.do";
        }else {
            return "error";
        }
    }
    @RequestMapping("componentupdate.do")
    public String ComponentUpdate(HttpServletRequest request){
        int cid = Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        BigDecimal cprice = new BigDecimal(request.getParameter("cprice"));
        Integer inventory = Integer.parseInt(request.getParameter("inventory"));

        Component component = new Component(cid,cname,cprice,inventory);
        int i = componentService.update(component);
        if (i>0){
            return "redirect:componentPage.do";
        }else {
            return "error";
        }
    }

    @RequestMapping("componentdelete.do")
    public String ComponentDelete(HttpServletRequest request){
        int cid = Integer.parseInt(request.getParameter("cid"));
        int i = componentService.delete(cid);
        if (i>0){
            return "redirect:componentPage.do";
        }else {
            return "error";
        }
    }
}
