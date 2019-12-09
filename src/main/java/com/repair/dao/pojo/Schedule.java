package com.repair.dao.pojo;

public class Schedule {
    private Integer schid;

    private Integer empno;

    private Integer phoneid;

    private String repairschdeule;

    private String expectresult;

    private String declares;

    public Schedule(Integer empno, Integer phoneid, String repairschdeule, String expectresult, String declares) {
        this.empno = empno;
        this.phoneid = phoneid;
        this.repairschdeule = repairschdeule;
        this.expectresult = expectresult;
        this.declares = declares;
    }

    public Schedule(Integer schid, Integer empno, Integer phoneid, String repairschdeule, String expectresult, String declares) {
        this.schid = schid;
        this.empno = empno;
        this.phoneid = phoneid;
        this.repairschdeule = repairschdeule;
        this.expectresult = expectresult;
        this.declares = declares;
    }

    public Schedule() {
        super();
    }

    public Integer getSchid() {
        return schid;
    }

    public void setSchid(Integer schid) {
        this.schid = schid;
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

    public String getRepairschdeule() {
        return repairschdeule;
    }

    public void setRepairschdeule(String repairschdeule) {
        this.repairschdeule = repairschdeule == null ? null : repairschdeule.trim();
    }

    public String getExpectresult() {
        return expectresult;
    }

    public void setExpectresult(String expectresult) {
        this.expectresult = expectresult == null ? null : expectresult.trim();
    }

    public String getDeclares() {
        return declares;
    }

    public void setDeclares(String declares) {
        this.declares = declares == null ? null : declares.trim();
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "schid=" + schid +
                ", empno=" + empno +
                ", phoneid=" + phoneid +
                ", repairschdeule='" + repairschdeule + '\'' +
                ", expectresult='" + expectresult + '\'' +
                ", declares='" + declares + '\'' +
                '}';
    }
}