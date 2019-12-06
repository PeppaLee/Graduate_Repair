package com.repair.dao.impl;

import com.repair.dao.idao.ISchedulePageDao;
import com.repair.dao.pojo.Schedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SchedulePageDaoImplTest {
private ISchedulePageDao schedulePageDao = new SchedulePageDaoImpl();

    @Test
    public void findSchedule() throws SQLException {
        List<Schedule> scheduleList = schedulePageDao.findSchedule(1002);
        scheduleList.forEach(System.out::print);
    }
}