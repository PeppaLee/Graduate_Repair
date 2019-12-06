package com.repair.dao.impl;

import com.repair.commons.PageBean;
import com.repair.dao.idao.ILoginPageDao;
import com.repair.dao.pojo.Login;
import com.repair.dao.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class LoginPageDaoImpl implements ILoginPageDao {
    @Override
    public void getAll(PageBean<Login> pageBean) throws Exception {
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
        String sql = "select * from login limit ?,?";
        List<Login> loginList = qr.query(sql, new BeanListHandler<Login>(Login.class), index, count);
        pageBean.setList(loginList);
    }

    @Override
    public int getTotalCount() throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select count(*) from login";
        Long count = qr.query(sql, new ScalarHandler<Long>());
        return count.intValue();
    }
}
