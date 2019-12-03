package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Emp;

public interface IEmpPageDao {
    //分页查询数据
    public void getAll(PageBean<Emp> pageBean) throws Exception;

    //查询总记录数
    public int getTotalCount() throws Exception;
}
