package com.repair.service.iservice;

import com.repair.dao.pojo.Login;

public interface ILoginService {
    public Login login(String username, String password);
}
