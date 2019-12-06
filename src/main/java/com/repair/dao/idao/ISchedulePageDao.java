package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Schedule;

import java.sql.SQLException;
import java.util.List;

public interface ISchedulePageDao {
    public void getAll(PageBean<Schedule> pageBean) throws Exception;
    public int getTotalCount() throws Exception;
    public List<Schedule> findSchedule(Integer empno) throws SQLException;
}
