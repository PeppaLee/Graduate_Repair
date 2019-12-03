package com.repair.service.impl;

import com.repair.dao.pojo.Component;
import com.repair.service.iservice.IComponentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ComponentServiceImplTest {

    @Autowired
    IComponentService componentService;

    @Test
    public void findById() {
        Component component = componentService.findById(1);
        System.out.println(component);
    }

    @Test
    public void save() {
        Component component = new Component("aaa", new BigDecimal("20.01"), 200);
        componentService.save(component);
    }

    @Test
    public void update() {
        Component component = componentService.findById(12);
        component.setCname("bbbb");
        componentService.update(component);
    }

    @Test
    public void delete() {
        componentService.delete(12);
    }

    @Test
    public void findByName() {
        componentService.findByName("机").forEach(System.out::println);
    }

}