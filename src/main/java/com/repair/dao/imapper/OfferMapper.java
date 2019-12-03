package com.repair.dao.imapper;

import com.repair.dao.pojo.Offer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfferMapper {
    int deleteByPrimaryKey(Integer partid);

    int insert(Offer record);

    int insertSelective(Offer record);

    Offer selectByPrimaryKey(Integer partid);

    int updateByPrimaryKeySelective(Offer record);

    int updateByPrimaryKey(Offer record);

    List<Offer> findByName(@Param("partName")String partName);
}