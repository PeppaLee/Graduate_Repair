package com.repair.service.impl;

import com.repair.dao.pojo.Record;
import com.repair.service.iservice.IRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RecordServiceImplTest {

    @Autowired
    IRecordService recordService;

    @Test
    public void findById() {
        Record record = recordService.findById(1);
        System.err.println(record);
    }

    @Test
    public void save() {
        Record record = new Record(1002,1,new Date(),new Date(),new BigDecimal("200"),"bbb");
        recordService.save(record);
    }

    @Test
    public void update() {
        Record record = recordService.findById(2);
        record.setEmpno(1004);
        recordService.update(record);
    }

    @Test
    public void findByEmp() {
        recordService.findByEmp(1001).forEach(System.out::println);
    }
}