package com.imooc.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    /**
     * @Description: 获取数据库连接
     * @Param: []
     * @return: Connection
     * @Author: jcsune
     * @Date: 2021/6/2
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        //1.加载并注册JDBC驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.创建数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imooc?useSSL=false&useUnicode=true&serverTimezone=Asia/Shanghai&characterEncoding=UTF-8",
                "root", "321074");

        return conn;
    }


    public static void closeConnection(Connection conn) {
        //关闭连接,释放资源
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
