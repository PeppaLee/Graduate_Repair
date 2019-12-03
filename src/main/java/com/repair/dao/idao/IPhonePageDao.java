package com.repair.dao.idao;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Phone;

public interface IPhonePageDao {
    public void getAll(PageBean<Phone> pageBean) throws Exception;
    public int getTotalCount() throws Exception;
}
