package com.repair.dao;

import com.repair.dao.pojo.Phone;

public interface PhoneMapper {
    int deleteByPrimaryKey(Integer phoneid);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(Integer phoneid);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);
}