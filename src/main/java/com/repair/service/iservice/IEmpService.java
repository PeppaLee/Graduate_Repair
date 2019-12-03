package com.repair.service.iservice;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Emp;

import java.util.List;

public interface IEmpService {
    Emp findById(Integer id);

    int save(Emp emp );

    int update(Emp emp);

    int delete(Integer empno);

    List<Emp> findByName(String ename) ;

    public void findAllByPage(PageBean<Emp> pageBean);
}
