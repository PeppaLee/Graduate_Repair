package com.repair.service.impl;

import com.github.pagehelper.PageHelper;
import com.repair.commons.PageBean;
import com.repair.dao.idao.IPhonePageDao;
import com.repair.dao.imapper.PhoneMapper;
import com.repair.dao.impl.PhonePageDaoImpl;
import com.repair.dao.pojo.Phone;
import com.repair.service.iservice.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("phoneService")
public class PhoneServiceImpl implements IPhoneService {
    private IPhonePageDao phonePageDao = new PhonePageDaoImpl();

    @Autowired
    PhoneMapper phoneMapper;

    @Override
    public Phone findById(Integer phoneid) {
        Phone phone = phoneMapper.selectByPrimaryKey(phoneid);
        return phone;
    }

    @Override
    public void findAllByPage(PageBean<Phone> pageBean) {
        try {
            phonePageDao.getAll(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Phone phone) {
        int i = phoneMapper.insert(phone);
        return i;
    }

    @Override
    public int update(Phone phone) {
        int i = phoneMapper.updateByPrimaryKey(phone);
        return i;
    }

    @Override
    public int delete(Integer phoneid) {
        int i = phoneMapper.deleteByPrimaryKey(phoneid);
        return i;
    }

    @Override
    public List<Phone> findByName(String ptype) {
        List<Phone> phoneList = phoneMapper.findByName(ptype);
        return phoneList;
    }


}
