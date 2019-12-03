package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Schedule;

public interface ISchedulePageDao {
    public void getAll(PageBean<Schedule> pageBean) throws Exception;
    public int getTotalCount() throws Exception;
}
