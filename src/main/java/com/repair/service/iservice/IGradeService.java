package com.repair.service.iservice;

import com.repair.commons.PageBean;
import com.repair.dao.pojo.Grade;

import java.util.List;

public interface IGradeService {
    Grade findById(Integer empno);

    int save(Grade grade );

    int update(Grade grade);

    int delete(Integer empno);

    List<Grade> findByName(String ename) ;

    public void findAllByPage(PageBean<Grade> pageBean);
}
