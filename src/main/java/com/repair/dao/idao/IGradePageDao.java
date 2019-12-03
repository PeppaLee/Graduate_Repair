package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Grade;

public interface IGradePageDao {
    public void getAll(PageBean<Grade> pageBean) throws Exception;
    public int getTotalCount() throws Exception;
}
