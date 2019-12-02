package com.repair.dao;

import com.repair.dao.pojo.Offer;

public interface OfferMapper {
    int deleteByPrimaryKey(Integer partid);

    int insert(Offer record);

    int insertSelective(Offer record);

    Offer selectByPrimaryKey(Integer partid);

    int updateByPrimaryKeySelective(Offer record);

    int updateByPrimaryKey(Offer record);
}