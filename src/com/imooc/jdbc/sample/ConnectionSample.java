package com.imooc.jdbc.sample;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionSample {

    public static void main(String[] args) {
        try {
            //加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建数据库连接
            //String url = "jdbc:mysql://localhost3306/imooc?useSSL=false&useUnicode=true&severTime=Asia/Shanghai&characterEncoding=UTF-8";
            String url = "jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8";
            Connection coon = DriverManager.getConnection(url, "root", "321074");
            System.out.println(coon);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/myemployees?useSSL=false&useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "321074");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }


}
