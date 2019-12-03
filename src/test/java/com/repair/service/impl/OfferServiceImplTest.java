package com.repair.service.impl;

import com.repair.dao.pojo.Offer;
import com.repair.service.iservice.IOfferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OfferServiceImplTest {

    @Autowired
    IOfferService offerService;

    @Test
    public void findById() {
        Offer offer = offerService.findById(2);
        System.err.println(offer);
    }

    @Test
    public void save() {
        Offer offer = new Offer("Aaa",new BigDecimal("20"));
        offerService.save(offer);
    }

    @Test
    public void update() {
        Offer offer = offerService.findById(14);
        offer.setPartname("bbb");
        offerService.update(offer);
    }

    @Test
    public void delete() {
        offerService.delete(14);
    }

    @Test
    public void findByName() {
        offerService.findByName("听").forEach(System.out::println);
    }
}