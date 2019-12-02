package com.company.dao.pojo;

import java.math.BigDecimal;

public class Offer {
    private Integer partid;

    private String partname;

    private BigDecimal offerprice;

    public Offer(Integer partid, String partname, BigDecimal offerprice) {
        this.partid = partid;
        this.partname = partname;
        this.offerprice = offerprice;
    }

    public Offer() {
        super();
    }

    public Integer getPartid() {
        return partid;
    }

    public void setPartid(Integer partid) {
        this.partid = partid;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname == null ? null : partname.trim();
    }

    public BigDecimal getOfferprice() {
        return offerprice;
    }

    public void setOfferprice(BigDecimal offerprice) {
        this.offerprice = offerprice;
    }
}