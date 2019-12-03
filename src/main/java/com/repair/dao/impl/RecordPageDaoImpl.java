package com.repair.dao.impl;

import com.repair.commons.PageBean;
import com.repair.dao.idao.IRecordPageDao;
import com.repair.dao.pojo.Phone;
import com.repair.dao.pojo.Record;
import com.repair.dao.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("recordPageDao")
public class RecordPageDaoImpl implements IRecordPageDao {
    @Override
    public void getAll(PageBean<Record> pageBean) throws Exception {
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
        String sql = "select * from record limit ?,?";
        List<Record> recordList = qr.query(sql, new BeanListHandler<Record>(Record.class), index, count);
        pageBean.setList(recordList);
    }

    @Override
    public int getTotalCount() throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select count(*) from record";
        Long count = qr.query(sql, new ScalarHandler<Long>());
        return count.intValue();
    }
}
