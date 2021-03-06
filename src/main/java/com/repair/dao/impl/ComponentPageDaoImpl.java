package com.repair.dao.impl;

import com.repair.commons.PageBean;
import com.repair.dao.idao.IComponentPageDao;
import com.repair.dao.pojo.Component;
import com.repair.dao.pojo.Emp;
import com.repair.dao.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("componentPageDao")
public class ComponentPageDaoImpl implements IComponentPageDao {
    @Override
    public void getAll(PageBean<Component> pageBean) throws Exception {
        int totalCount = getTotalCount();
        pageBean.setTotalCount(totalCount);
        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();

        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select * from component limit ?,?";
        List<Component> componentList = qr.query(sql, new BeanListHandler<Component>(Component.class), index, count);
        pageBean.setList(componentList);

    }

    @Override
    public int getTotalCount() throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select count(*) from component";
        Long count = qr.query(sql, new ScalarHandler<Long>());
        return count.intValue();
    }
}
