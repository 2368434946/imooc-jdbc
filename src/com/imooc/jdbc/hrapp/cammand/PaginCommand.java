package com.imooc.jdbc.hrapp.cammand;

import com.imooc.jdbc.common.DbUtils;
import com.imooc.jdbc.hrapp.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//分页查询员工数据
public class PaginCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入页号");
        int page = scanner.nextInt();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList();

        try {
            conn = DbUtils.getConnection();
            String sql = "select * from employee limit ?,10";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (page - 1) * 10);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Integer eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                //JDBC获取日期使用java.sql.Date,其继承自java.util.Date
                //所以两者互相兼容
                Date hiredate = rs.getDate("hiredate");
                Employee employee = new Employee();
                employee.setEno(eno);
                employee.setEname(ename);
                employee.setSalary(salary);
                employee.setDname(dname);
                employee.setHiredate(hiredate);
                System.out.println(employee);
                list.add(employee);

            }
            System.out.println(list.size());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeConnection(conn);
        }

    }
}
