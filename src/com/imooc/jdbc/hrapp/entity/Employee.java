package com.imooc.jdbc.hrapp.entity;

import java.util.Date;

//员工实体类
public class Employee {

    /*
     * 标准JavaBean
     * 1.具备默认构造函数
     * 2.属性私有
     * 3.存在getter()和setter
     *
     * */
    private Integer eno;//员工编号
    private String ename;//员工姓名
    private Float salary;//薪资
    private String dname;//部门名称
    private Date hiredate;//入职日期

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", dname='" + dname + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }
}
