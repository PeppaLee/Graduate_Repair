package com.repair.service.impl;

import com.github.pagehelper.PageHelper;
import com.repair.commons.PageBean;
import com.repair.dao.idao.IEmpPageDao;
import com.repair.dao.imapper.EmpMapper;
import com.repair.dao.impl.EmpPageDaoImpl;
import com.repair.dao.pojo.Emp;
import com.repair.service.iservice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empService")
public class EmpServiceImpl implements IEmpService {

    private IEmpPageDao empPageDao = new EmpPageDaoImpl();

    @Autowired
    EmpMapper empMapper;


    @Override
    public Emp findById(Integer id) {
        Emp emp = empMapper.selectByPrimaryKey(id);
        return emp;
    }

    @Override
    public void findAllByPage(PageBean<Emp> pageBean) {
        try {
            empPageDao.getAll(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Emp emp) {
        int i = empMapper.insert(emp);
        return i;
    }

    @Override
    public int update(Emp emp) {
        int i = empMapper.updateByPrimaryKey(emp);
        return i;
    }

    @Override
    public int delete(Integer empno) {
        int i = empMapper.deleteByPrimaryKey(empno);
        return i;
    }

    @Override
    public List<Emp> findByName(String ename) {
        List<Emp> empList = empMapper.findByName(ename);
        return empList;
    }


}
