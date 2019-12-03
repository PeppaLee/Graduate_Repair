package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Record;

public interface IRecordPageDao {
    public void getAll(PageBean<Record> pageBean) throws Exception;
    public int getTotalCount() throws Exception;
}
