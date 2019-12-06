package com.repair.dao.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Record {
    private Integer recordid;

    private Integer empno;

    private Integer phoneid;

    private Date startday;

    private Date endday;

    private BigDecimal charge;

    private String result;

    public Record(Integer empno, Integer phoneid, Date startday, Date endday, BigDecimal charge, String result) {
        this.empno = empno;
        this.phoneid = phoneid;
        this.startday = startday;
        this.endday = endday;
        this.charge = charge;
        this.result = result;
    }

    public Record(Integer recordid, Integer empno, Integer phoneid, Date startday, Date endday, BigDecimal charge, String result) {
        this.recordid = recordid;
        this.empno = empno;
        this.phoneid = phoneid;
        this.startday = startday;
        this.endday = endday;
        this.charge = charge;
        this.result = result;
    }

    public Record() {
        super();
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Integer getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(Integer phoneid) {
        this.phoneid = phoneid;
    }

    public Date getStartday() {
        return startday;
    }

    public void setStartday(Date startday) {
        this.startday = startday;
    }

    public Date getEndday() {
        return endday;
    }

    public void setEndday(Date endday) {
        this.endday = endday;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordid=" + recordid +
                ", empno=" + empno +
                ", phoneid=" + phoneid +
                ", startday=" + startday +
                ", endday=" + endday +
                ", charge=" + charge +
                ", result='" + result + '\'' +
                '}';
    }
}