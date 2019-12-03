package com.repair.dao.pojo;

public class Phone {
    private Integer phoneid;

    private String ptype;

    private String reason;

    public Phone(Integer phoneid, String ptype, String reason) {
        this.phoneid = phoneid;
        this.ptype = ptype;
        this.reason = reason;
    }

    public Phone() {
        super();
    }

    public Integer getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(Integer phoneid) {
        this.phoneid = phoneid;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype == null ? null : ptype.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Phone(String ptype, String reason) {
        this.ptype = ptype;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneid=" + phoneid +
                ", ptype='" + ptype + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}