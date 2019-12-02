package com.repair.dao;

import com.repair.dao.pojo.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}