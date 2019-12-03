package com.repair.dao.imapper;

import com.repair.dao.pojo.Phone;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhoneMapper {
    int deleteByPrimaryKey(Integer phoneid);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(Integer phoneid);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);

    List<Phone> findByName(@Param("ptype")String ptype);
}