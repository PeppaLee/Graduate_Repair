package com.repair.dao.pojo;

public class Login {
    private Integer userid;

    private String username;

    private String password;

    private Integer pri;

    private Integer empno;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Login(Integer userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public Login(String username, String password, Integer pri) {
        this.username = username;
        this.password = password;
        this.pri = pri;
    }

    public Login(Integer userid, String username, String password, Integer pri) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.pri = pri;
    }

    public Login() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPri() {
        return pri;
    }

    public void setPri(Integer pri) {
        this.pri = pri;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pri=" + pri +
                '}';
    }
}