package com.repair.service.iservice;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Emp;
import com.repair.dao.pojo.Login;
import sun.rmi.runtime.Log;

import java.util.List;

public interface ILoginService {
    public Login login(String username, String password);

    int save(Login login );

    int delete(Integer userid);

    int update(Login login);

    public void findAllByPage(PageBean<Login> pageBean);

    public List<Login> fingdByName(String username);

    public Login findExist(String username);

    public int updatePassword(Login login);
}
