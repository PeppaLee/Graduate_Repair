package com.repair.service.impl;

import com.github.pagehelper.PageHelper;
import com.repair.commons.PageBean;
import com.repair.dao.idao.IRecordPageDao;
import com.repair.dao.imapper.RecordMapper;
import com.repair.dao.impl.RecordPageDaoImpl;
import com.repair.dao.pojo.Record;
import com.repair.service.iservice.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("recordService")
public class RecordServiceImpl implements IRecordService {
    private IRecordPageDao recordPageDao = new RecordPageDaoImpl();

    @Autowired
    RecordMapper recordMapper;

    @Override
    public Record findById(Integer recordid) {
        Record record = recordMapper.selectByPrimaryKey(recordid);
        return record;
    }

    @Override
    public void findAllByPage(PageBean<Record> pageBean) {
        try {
            recordPageDao.getAll(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Record record) {
        int i = recordMapper.insert(record);
        return i;
    }

    @Override
    public int update(Record record) {
        int i = recordMapper.updateByPrimaryKey(record);
        return i;
    }

//    @Override
//    public int delete(Integer recordid) {
//        return 0;
//    }

    @Override
    public List<Record> findByEmp(Integer empno) {
       List<Record> recordList = recordMapper.findByEmp(empno);
        return recordList;
    }


}
