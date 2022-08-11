package com.imooc.jdbc.sample;

import com.imooc.jdbc.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//事务提交案例: 实现批量添加员工
public class TransactionSample {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DbUtils.getConnection();
            //JDBC默认使用自动提交模式  conn.setAutoCommit(true)
            conn.setAutoCommit(false);//关闭自动提交
            String sql = "insert into employee(eno,ename,salary,dname,hiredate) values(?,?,?,?,?)";
            for (int i = 1000; i < 2000; i++) {
                if (i == 1005) {
                    //throw new RuntimeException
                }
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, i);
                pstmt.setString(2, "员工" + i);
                pstmt.setFloat(3, 4000f);
                pstmt.setString(4, "市场部");

                //string 到 java.sql.Date分为两步

                //1. String转为java.util.Date
                java.util.Date udHiredate = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    udHiredate = sdf.parse(i + 1000 + "-6-28");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //2.java.util.Date转为java.sql.Date
                long time = udHiredate.getTime();//获取自1970年到现在的毫秒数
                java.sql.Date sdHiredate = new java.sql.Date(time);
                pstmt.setDate(5, sdHiredate);
                pstmt.executeUpdate();
            }
            conn.commit();//提交数据
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.rollback();
                }
                conn.rollback();//回滚数据
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DbUtils.closeConnection(conn);
        }
    }


}
