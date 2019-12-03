package com.repair.service.iservice;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Record;

import java.util.List;

public interface IRecordService {
    Record findById(Integer recordid);

    int save(Record record);

    int update(Record record);

//    int delete(Integer recordid);

    List<Record> findByEmp(Integer empno);

    public void findAllByPage(PageBean<Record> pageBean);

}
