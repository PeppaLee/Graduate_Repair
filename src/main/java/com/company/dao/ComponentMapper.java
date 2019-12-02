package com.company.dao;

import com.company.dao.pojo.Component;

public interface ComponentMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Component record);

    int insertSelective(Component record);

    Component selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Component record);

    int updateByPrimaryKey(Component record);
}