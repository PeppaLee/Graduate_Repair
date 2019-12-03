package com.repair.dao.imapper;

import com.repair.dao.pojo.Component;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComponentMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Component record);

    int insertSelective(Component record);

    Component selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Component record);

    int updateByPrimaryKey(Component record);

    List<Component> findByName(@Param("cname") String cname);

}