package com.repair.dao;

import com.repair.dao.imapper.LoginMapper;
import com.repair.dao.pojo.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class LoginMapperTest {

    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void selectLogin() {
        Login login = loginMapper.selectLogin("admin","123456");
        System.out.println(login);

    }
}