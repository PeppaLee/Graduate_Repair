package com.repair.dao.imapper;

import com.repair.dao.pojo.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer schid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer schid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

    List<Schedule> findByEmp(@Param("empno")Integer empno);
}