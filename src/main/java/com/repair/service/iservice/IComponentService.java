package com.repair.service.iservice;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Component;

import java.util.List;

public interface IComponentService {
    Component findById(Integer id);

    int save(Component component);

    int update(Component component);

    int delete(Integer cid);

    List<Component> findByName(String cname) ;

    public void findAllByPage(PageBean<Component> pageBean);
}
