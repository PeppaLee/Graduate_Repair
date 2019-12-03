package com.repair.service.impl;

import com.repair.dao.pojo.Grade;
import com.repair.service.iservice.IGradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GradeServiceImplTest {

    @Autowired
    IGradeService gradeService;

    @Test
    public void findById() {
        Grade grade = gradeService.findById(1001);
        System.err.println(grade);
    }

    @Test
    public void save() {
        Grade grade = new Grade(1014,"aaa",100,100,"A");
        gradeService.save(grade);
    }

    @Test
    public void update() {
        Grade grade = gradeService.findById(1014);
        grade.setEname("bbbb");
        gradeService.update(grade);
    }

    @Test
    public void delete() {
        gradeService.delete(1014);
    }

    @Test
    public void findByName() {
        gradeService.findByName("王").forEach(System.out::println);
    }
}