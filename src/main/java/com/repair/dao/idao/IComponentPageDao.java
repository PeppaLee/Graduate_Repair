package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Component;

public interface IComponentPageDao {
    public void getAll(PageBean<Component> pageBean) throws Exception;
    public int getTotalCount() throws Exception;
}
