package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Offer;
import com.repair.service.iservice.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class OfferAction {

    @Autowired
    IOfferService offerService;

    @RequestMapping("offerpage.do")
    public String OfferPage(HttpServletRequest request) {
        String url = null;
        try {
            String currPage = request.getParameter("currentPage");
            //判断   第一次是设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }
            int currentPage = Integer.parseInt(currPage);
            PageBean<Offer> pb = new PageBean<Offer>();
            pb.setCurrentPage(currentPage);
            offerService.findAllByPage(pb);
            request.setAttribute("pageBean", pb);
            url = "offer";
        } catch (NumberFormatException e) {
            url = "error";
        }
        return url;
    }

    @RequestMapping("offerrouter.do")
    public String OfferRouter(@RequestParam("router") String router) {
        if ("offer_add".equalsIgnoreCase(router)) {
            return "offer_add";
        } else if ("offer_select".equalsIgnoreCase(router)) {
            return "offer_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("offersave.do")
    public String OfferSave(HttpServletRequest request) {
        String partname = request.getParameter("partname");
        BigDecimal offerprice = new BigDecimal(request.getParameter("offerprice"));

        Offer offer = new Offer(partname, offerprice);
        int i = offerService.save(offer);
        if (i > 0) {
            return "redirect:offerpage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("offerupdate.do")
    public String OfferUpdate(HttpServletRequest request) {
        int partid = Integer.parseInt(request.getParameter("partid"));
        String partname = request.getParameter("partname");
        BigDecimal offerprice = new BigDecimal(request.getParameter("offerprice"));
        Offer offer = new Offer(partid,partname, offerprice);
        int i = offerService.update(offer);
        if (i > 0) {
            return "redirect:offerpage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("offerid.do")
    public String OfferFindById(HttpServletRequest request) {
        String type = request.getParameter("type");
        int partid = Integer.parseInt(request.getParameter("partid"));
        Offer offer = offerService.findById(partid);
        if (offer != null) {
            if ("update".equalsIgnoreCase(type)) {
                request.setAttribute("offer", offer);
                return "offer_update";
            } else {
                request.setAttribute("offerList", Arrays.asList(offer));
                return "offer_select";
            }
        } else {
            return "error";
        }
    }

    @RequestMapping("offername.do")
    public String OfferFindByName(HttpServletRequest request) {
        String partname = request.getParameter("partname");
        List<Offer> offerList = offerService.findByName(partname);
        if (offerList != null && offerList.size() > 0) {
            request.setAttribute("offerList", offerList);
            return "offer_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("offerdelete.do")
    public String OfferDelete(HttpServletRequest request) {
        int partid = Integer.parseInt(request.getParameter("partid"));
        int i = offerService.delete(partid);
        if (i > 0) {
            return "redirect:offerpage.do";
        } else {
            return "error";
        }
    }
}
