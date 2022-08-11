package com.imooc.jdbc.sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StandardJDBCSample {


    public static void main(String[] args) {
        Connection coon = null;
        try {
            //1.加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建数据库连接
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8",
                    "root", "321074");

            //3.创建Statemen对象
            Statement stmt = coon.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from employee");
            //4.遍历查询结果
            while (rs.next()) {
                Integer eno = rs.getInt(1);
                String ename = rs.getString("ename");
                float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                System.out.println(dname + "-" + eno + "-" + ename + "-" + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接,释放资源
            try {
                if (coon != null && coon.isClosed() == false) {
                    coon.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
