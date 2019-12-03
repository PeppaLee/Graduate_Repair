package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Component;
import com.repair.dao.pojo.Offer;

public interface IOfferPageDao {
    public void getAll(PageBean<Offer> pageBean) throws Exception;
    public int getTotalCount() throws Exception;
}
