package com.repair.service.impl;

import com.repair.dao.pojo.Phone;
import com.repair.service.iservice.IPhoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PhoneServiceImplTest {

    @Autowired
    IPhoneService phoneService;

    @Test
    public void findById() {
        Phone phone = phoneService.findById(13);
        System.err.println(phone);
    }

    @Test
    public void save() {
        Phone phone = new Phone("xm14","aaaa");
        phoneService.save(phone);
    }

    @Test
    public void update() {
        Phone phone = phoneService.findById(14);
        phone.setReason("bbbbbbb");
        phoneService.update(phone);
    }

    @Test
    public void delete() {
        phoneService.delete(14);
    }

    @Test
    public void findByName() {
        phoneService.findByName("xm").forEach(System.out::println);
    }
}