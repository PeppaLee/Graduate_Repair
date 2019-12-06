package com.repair.service.impl;

import com.repair.commons.PageBean;
import com.repair.dao.idao.ILoginPageDao;
import com.repair.dao.imapper.LoginMapper;
import com.repair.dao.impl.LoginPageDaoImpl;
import com.repair.dao.pojo.Login;
import com.repair.dao.utils.DBUtils;
import com.repair.service.iservice.ILoginService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.sql.SQLException;
import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    private ILoginPageDao loginPageDao = new LoginPageDaoImpl();

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login login(String username, String password) {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = " select userid,username,`password`,pri,empno from login where username=? and `password`=md5(?)";
        Login login = null;
        try {
            login = qr.query(sql,new BeanHandler<Login>(Login.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Login login = loginMapper.selectLogin(username, password);
        return login;
    }

    @Override
    public int save(Login login) {
        int i = loginMapper.insert(login);
        return i;
    }

    @Override
    public int delete(Integer userid) {
        int i = loginMapper.deleteByPrimaryKey(userid);
        return i;
    }

    @Override
    public int update(Login login) {
        int i = loginMapper.updateByPrimaryKey(login);
        return i;
    }

    @Override
    public void findAllByPage(PageBean<Login> pageBean) {
        try {
            loginPageDao.getAll(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Login> fingdByName(String username) {
        List<Login> loginList = loginMapper.findByName(username);
        return loginList;
    }

    @Override
    public Login findExist(String username) {
        Login login = loginMapper.findExist(username);
        return login;
    }

    @Override
    public int updatePassword(Login login) {
        int i = loginMapper.updatePassword(login);
        return i;
    }
}
