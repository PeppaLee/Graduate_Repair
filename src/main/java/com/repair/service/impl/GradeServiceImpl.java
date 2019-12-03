package com.repair.service.impl;

import com.github.pagehelper.PageHelper;
import com.repair.commons.PageBean;
import com.repair.dao.idao.IGradePageDao;
import com.repair.dao.imapper.GradeMapper;
import com.repair.dao.impl.GradePageDaoImpl;
import com.repair.dao.pojo.Grade;
import com.repair.service.iservice.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gradeService")
public class GradeServiceImpl implements IGradeService {
    private IGradePageDao gradePageDao = new GradePageDaoImpl();

    @Autowired
    GradeMapper gradeMapper;

    @Override
    public Grade findById(Integer empno) {
        Grade grade = gradeMapper.selectByPrimaryKey(empno);
        return grade;
    }

    @Override
    public void findAllByPage(PageBean<Grade> pageBean) {
        try {
            gradePageDao.getAll(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Grade grade) {
        int i = gradeMapper.insert(grade);
        return i;
    }

    @Override
    public int update(Grade grade) {
        int i = gradeMapper.updateByPrimaryKey(grade);
        return i;
    }

    @Override
    public int delete(Integer empno) {
        int i = gradeMapper.deleteByPrimaryKey(empno);
        return i;
    }

    @Override
    public List<Grade> findByName(String ename) {
        List<Grade> gradeList = gradeMapper.findByName(ename);
        return gradeList;
    }


}
