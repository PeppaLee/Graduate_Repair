package com.repair.service.iservice;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Phone;

import java.util.List;

public interface IPhoneService {
    Phone findById(Integer phoneid);

    int save(Phone phone);

    int update(Phone phone);

    int delete(Integer phoneid);

    List<Phone> findByName(String ptype) ;

    public void findAllByPage(PageBean<Phone> pageBean);
}
