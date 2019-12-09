package com.repair.action;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Emp;
import com.repair.dao.pojo.Record;
import com.repair.service.iservice.IRecordService;
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
public class RecordAction {
    @Autowired
    IRecordService recordService;

    @RequestMapping("recordpage.do")
    public String RecordPage(HttpServletRequest request, HttpServletResponse response) {
        String url = null;
        try {
            String currPage = request.getParameter("currentPage");
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }
            int currentPage = Integer.parseInt(currPage);
            PageBean<Record> pb = new PageBean<Record>();
            pb.setCurrentPage(currentPage);
            recordService.findAllByPage(pb);
            request.setAttribute("pageBean", pb);
            url = "record";
        } catch (NumberFormatException e) {
            url = "error";
        }
        return url;
    }

    @RequestMapping("recordsave.do")
    public String RecordSave(HttpServletRequest request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int empno = Integer.parseInt(request.getParameter("empno"));
        int phoneid = Integer.parseInt(request.getParameter("phoneid"));
        String startday = request.getParameter("startday");
        String endday = request.getParameter("endday");
        BigDecimal charge = new BigDecimal(request.getParameter("charge"));
        String result = request.getParameter("result");

        Record record = new Record(empno, phoneid, sdf.parse(startday), sdf.parse(endday), charge, result);
        int i = recordService.save(record);
        if (i > 0) {
            return "redirect:recordpage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("recordrouter.do")
    public String RecordRouter(@RequestParam(value = "router") String router) {
        if ("record_add".equals(router)) {
            return "record_add";
        } else if ("record_select".equalsIgnoreCase(router)) {
            return "record_select";
        } else {
            return "error";
        }
    }

    @RequestMapping("recordupdate.do")
    public String RecordUpdate(HttpServletRequest request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int recordid = Integer.parseInt(request.getParameter("recordid"));
        int empno = Integer.parseInt(request.getParameter("empno"));
        int phoneid = Integer.parseInt(request.getParameter("phoneid"));
        String startday = request.getParameter("startday");
        String endday = request.getParameter("endday");
        BigDecimal charge = new BigDecimal(request.getParameter("charge"));
        String result = request.getParameter("result");

        Record record = new Record(recordid, empno, phoneid, sdf.parse(startday), sdf.parse(endday), charge, result);
        int i = recordService.update(record);
        if (i > 0) {
            return "redirect:recordpage.do";
        } else {
            return "error";
        }
    }

    @RequestMapping("recordid.do")
    public String RecordFindById(HttpServletRequest request) {
        String type = request.getParameter("type");
        int recordid = Integer.parseInt(request.getParameter("recordid"));
        Record record = recordService.findById(recordid);
        if (record != null) {
            if ("update".equalsIgnoreCase(type)) {
                request.setAttribute("record", record);
                return "record_update";
            } else {
                request.setAttribute("recordList", Arrays.asList(record));
                return "record_select";
            }
        } else {
            return "record_select_error";
        }
    }

    @RequestMapping("recordemp.do")
    public String RecordFindByEmp(HttpServletRequest request) {
        int empno = Integer.parseInt(request.getParameter("empno"));
        List<Record> recordList = recordService.findByEmp(empno);
        if (recordList != null && recordList.size() > 0) {
            request.setAttribute("recordList", recordList);
            return "record_select";
        } else {
            return "record_select_error";
        }
    }

}
