package com.repair.dao.imapper;

import com.repair.dao.pojo.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Integer userid);

    Login selectLogin(@Param("username")String username,@Param("password")String password);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);

    List<Login> findByName(@Param("username")String username);

    Login findExist(@Param("username")String username);

    int updatePassword(Login record);
}