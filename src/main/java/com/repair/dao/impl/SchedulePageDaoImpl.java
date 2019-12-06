package com.repair.dao.impl;

import com.repair.commons.PageBean;
import com.repair.dao.idao.ISchedulePageDao;
import com.repair.dao.pojo.Schedule;
import com.repair.dao.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public class SchedulePageDaoImpl implements ISchedulePageDao {
    @Override
    public void getAll(PageBean<Schedule> pageBean) throws Exception {
        int totalCount = getTotalCount();
        pageBean.setTotalCount(totalCount);
        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();

        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select * from schedule limit ?,?";
        List<Schedule> scheduleList = qr.query(sql, new BeanListHandler<Schedule>(Schedule.class), index, count);
        pageBean.setList(scheduleList);
    }

    @Override
    public int getTotalCount() throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select count(*) from schedule";
        Long count = qr.query(sql, new ScalarHandler<Long>());
        return count.intValue();
    }

    @Override
    public List<Schedule> findSchedule(Integer empno) throws SQLException {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select s.schid,s.empno,s.phoneid,s.repairschdeule,s.expectresult,s.declares from `schedule` s,emp e,login l where l.empno=e.empno and e.empno = s.empno and e.empno=?";
        List<Schedule> scheduleList = qr.query(sql,new BeanListHandler<Schedule>(Schedule.class),empno);
        return scheduleList;
    }
}
