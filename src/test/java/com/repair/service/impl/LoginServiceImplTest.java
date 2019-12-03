package com.repair.service.impl;

import com.repair.dao.pojo.Login;
import com.repair.service.iservice.ILoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class LoginServiceImplTest {

    @Autowired
    ILoginService loginService;
    @Test
    public void login() {
        Login login = loginService.login("admin","123456");
        System.out.println(login);
    }
}