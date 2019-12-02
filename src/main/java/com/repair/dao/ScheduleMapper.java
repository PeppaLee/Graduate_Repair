package com.repair.dao;

import com.repair.dao.pojo.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer schid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer schid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}