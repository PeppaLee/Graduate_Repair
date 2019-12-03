package com.repair.service.impl;

import com.repair.dao.imapper.LoginMapper;
import com.repair.dao.pojo.Login;
import com.repair.service.iservice.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login login(String username, String password) {
        Login login = loginMapper.selectLogin(username,password);
        return login;
    }
}
