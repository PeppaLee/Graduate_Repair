package com.repair.dao.pojo;

public class Grade {
    private Integer empno;

    private String ename;

    private Integer times;

    private Integer successtimes;

    private String grade;

    public Grade(Integer empno, String ename, Integer times, Integer successtimes, String grade) {
        this.empno = empno;
        this.ename = ename;
        this.times = times;
        this.successtimes = successtimes;
        this.grade = grade;
    }

    public Grade() {
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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getSuccesstimes() {
        return successtimes;
    }

    public void setSuccesstimes(Integer successtimes) {
        this.successtimes = successtimes;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    @Override
    public String toString() {
        return "Grade{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", times=" + times +
                ", successtimes=" + successtimes +
                ", grade='" + grade + '\'' +
                '}';
    }
}