package com.repair.service.impl;

import com.github.pagehelper.PageHelper;
import com.repair.commons.PageBean;
import com.repair.dao.idao.ISchedulePageDao;
import com.repair.dao.imapper.ScheduleMapper;
import com.repair.dao.impl.SchedulePageDaoImpl;
import com.repair.dao.pojo.Schedule;
import com.repair.service.iservice.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("scheduleService")
public class ScheduleServiceImpl implements IScheduleService {
    private ISchedulePageDao schedulePageDao = new SchedulePageDaoImpl();

    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    public Schedule findById(Integer schid) {
        Schedule schedule = scheduleMapper.selectByPrimaryKey(schid);
        return schedule;
    }

    @Override
    public void findAllByPage(PageBean<Schedule> pageBean) {
        try {
            schedulePageDao.getAll(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Schedule> findSelf(Integer empno) {
        List<Schedule> scheduleList = null;
        try {
             scheduleList = schedulePageDao.findSchedule(empno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    @Override
    public int save(Schedule schedule) {
        int i = scheduleMapper.insert(schedule);
        return i;
    }

    @Override
    public int update(Schedule schedule) {
        int i = scheduleMapper.updateByPrimaryKey(schedule);
        return i;
    }

    @Override
    public int delete(Integer schid) {
        int i = scheduleMapper.deleteByPrimaryKey(schid);
        return i;
    }

    @Override
    public List<Schedule> findByEmp(Integer empno) {
        List<Schedule> scheduleList = scheduleMapper.findByEmp(empno);
        return scheduleList;
    }


}
