package com.repair.service.impl;

import com.repair.commons.PageBean;
import com.repair.dao.idao.IComponentPageDao;
import com.repair.dao.imapper.ComponentMapper;
import com.repair.dao.impl.ComponentPageDaoImpl;
import com.repair.dao.pojo.Component;
import com.repair.service.iservice.IComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("componentService")
public class ComponentServiceImpl implements IComponentService {
    private IComponentPageDao componentPageDao = new ComponentPageDaoImpl();

    @Autowired
    ComponentMapper componentMapper;

    @Override
    public Component findById(Integer id) {
        Component component = componentMapper.selectByPrimaryKey(id);
        return component;
    }

    @Override
    public void findAllByPage(PageBean<Component> pageBean) {
        try {
            componentPageDao.getAll(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Component component) {
       int i = componentMapper.insert(component);
       return i;
    }

    @Override
    public int update(Component component) {
        int i = componentMapper.updateByPrimaryKey(component);
        return i;
    }

    @Override
    public int delete(Integer cid) {
        int i = componentMapper.deleteByPrimaryKey(cid);
        return i;
    }

    @Override
    public List<Component> findByName(String cname) {
        List<Component> componentList = componentMapper.findByName(cname);
        return componentList;
    }




}
