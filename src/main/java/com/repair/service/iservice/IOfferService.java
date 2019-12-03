package com.repair.service.iservice;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Offer;

import java.util.List;

public interface IOfferService {
    Offer findById(Integer id);

    int save(Offer offer);

    int update(Offer offer);

    int delete(Integer partid);

    List<Offer> findByName(String partname) ;

    public void findAllByPage(PageBean<Offer> pageBean);
}
