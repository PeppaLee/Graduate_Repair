package com.repair.dao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Emp {
    private Integer empno;

    private String ename;

    private String gender;

    private String grade;

    private BigDecimal sal;

    private Date hiredate;

    private Integer partid;

    public Emp(Integer empno, String ename, String gender, String grade, BigDecimal sal, Date hiredate, Integer partid) {
        this.empno = empno;
        this.ename = ename;
        this.gender = gender;
        this.grade = grade;
        this.sal = sal;
        this.hiredate = hiredate;
        this.partid = partid;
    }

    public Emp() {
        super();
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Integer getPartid() {
        return partid;
    }

    public void setPartid(Integer partid) {
        this.partid = partid;
    }
}