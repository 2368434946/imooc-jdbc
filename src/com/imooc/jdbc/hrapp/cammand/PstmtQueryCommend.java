package com.imooc.jdbc.hrapp.cammand;

import java.sql.*;
import java.util.Scanner;

public class PstmtQueryCommend implements Command {
    @Override
    public void execute() {
        System.out.println("请输入部门名称:");
        Scanner scanner = new Scanner(System.in);
        String pdname = scanner.nextLine();
        Connection conn = null;
        //Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            //1.加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8",
                    "root", "321074");
            //3.创建preparedStatement对象
            String sql = "select * from employee where dname = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pdname);
            //结果集
            rs = pstmt.executeQuery();

            //4.遍历查询结果
            while (rs.next()) {
                //rs.next()返回布尔值,代表是否存在下一条记录
                //如果有,返回true,同时结果集提取下一条记录
                //如果没有,返回false,循环就会停止
                Integer eno = rs.getInt(1);
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                System.out.println(dname + "-" + eno + "-" + ename + "-" + salary);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接,释放资源
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
