package com.company.dao.pojo;

import java.math.BigDecimal;

public class Component {
    private Integer cid;

    private String cname;

    private BigDecimal cprice;

    private Integer inventory;

    public Component(Integer cid, String cname, BigDecimal cprice, Integer inventory) {
        this.cid = cid;
        this.cname = cname;
        this.cprice = cprice;
        this.inventory = inventory;
    }

    public Component() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public BigDecimal getCprice() {
        return cprice;
    }

    public void setCprice(BigDecimal cprice) {
        this.cprice = cprice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}