package com.repair.service.impl;

import com.repair.dao.pojo.Emp;
import com.repair.service.iservice.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmpServiceImplTest {

    @Autowired
    IEmpService empService;

    @Test
    public void findById() {
        Emp emp = empService.findById(1001);
        System.out.println(emp);
    }

    @Test
    public void save() {
        Emp emp = new Emp("Aaa","male","A",new BigDecimal("20"),new Date(),2);
        empService.save(emp);
    }

    @Test
    public void update() {
        Emp emp = empService.findById(1013);
        emp.setEname("BBBBB");
        empService.update(emp);
    }

    @Test
    public void delete() {
        empService.delete(1013);
    }

    @Test
    public void findByName() {
        List<Emp> empList = empService.findByName("张");
        empList.forEach(System.out::println);
    }
}