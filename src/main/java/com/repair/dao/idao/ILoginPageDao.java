package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Login;

public interface ILoginPageDao {
    public void getAll(PageBean<Login> pageBean) throws Exception;
    public int getTotalCount() throws Exception;
}
