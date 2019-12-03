package com.repair.service.impl;

import com.github.pagehelper.PageHelper;
import com.repair.commons.PageBean;
import com.repair.dao.idao.IOfferPageDao;
import com.repair.dao.imapper.OfferMapper;
import com.repair.dao.impl.OfferPageDaoImpl;
import com.repair.dao.pojo.Offer;
import com.repair.service.iservice.IOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("offerService")
public class OfferServiceImpl implements IOfferService {
    private IOfferPageDao offerPageDao = new OfferPageDaoImpl();

    @Autowired
    OfferMapper offerMapper;

    @Override
    public Offer findById(Integer id) {
        Offer offer = offerMapper.selectByPrimaryKey(id);
        return offer;
    }
    @Override
    public void findAllByPage(PageBean<Offer> pageBean) {
        try {
            offerPageDao.getAll(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Offer offer) {
        int i = offerMapper.insert(offer);
        return i;
    }

    @Override
    public int update(Offer offer) {
        int i = offerMapper.updateByPrimaryKey(offer);
        return i;
    }

    @Override
    public int delete(Integer partid) {
        int i = offerMapper.deleteByPrimaryKey(partid);
        return i;
    }

    @Override
    public List<Offer> findByName(String partname) {
        List<Offer> offerList = offerMapper.findByName(partname);
        return offerList;
    }


}
