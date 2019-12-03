package com.repair.dao.impl;

import com.repair.commons.PageBean;
import com.repair.dao.idao.IEmpPageDao;
import com.repair.dao.pojo.Emp;
import com.repair.dao.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("empPageDao")
public class EmpPageDaoImpl implements IEmpPageDao {

    @Override
    public void getAll(PageBean<Emp> pageBean) throws Exception {
        //查询总记录数；  并设置保存到pageBean对象中
        int totalCount = getTotalCount();
        pageBean.setTotalCount(totalCount);
        /*
         * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
         *              如果当前页为末页，再点下一页显示有问题！
         * 解决：
         *        1. 如果当前页 <= 0;       当前页设置当前页为1;
         *        2. 如果当前页 > 最大页数；  当前页设置为最大页数
         */
        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        //获取当前页：计算查询的起始行、返回行数
        int currentPage = pageBean.getCurrentPage();
        int index = (currentPage - 1) * pageBean.getPageCount();
        int count = pageBean.getPageCount();

        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select * from emp limit ?,?";
        List<Emp> empList = qr.query(sql, new BeanListHandler<Emp>(Emp.class), index, count);
        pageBean.setList(empList);
    }

    @Override
    public int getTotalCount() throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select count(*) from emp";
       /*/
        ScalarHandler的作用是将数据库中某一个字段的数据封装成一个Object对象。
           将Object结果转成包装类Long再取intValue()的方法转为int
        */
        Long count = qr.query(sql, new ScalarHandler<Long>());
        return count.intValue();
    }
}
