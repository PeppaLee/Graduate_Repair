package com.repair.service.iservice;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Schedule;

import java.util.List;

public interface IScheduleService {
    Schedule findById(Integer schid);

    int save(Schedule schedule);

    int update(Schedule schedule);

    int delete(Integer schid);

    List<Schedule> findByEmp(Integer empno);

    public void findAllByPage(PageBean<Schedule> pageBean);
}
