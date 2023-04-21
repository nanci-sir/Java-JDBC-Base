package com.nancijdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API 详解：Connection
 */
public class JDBCDemo2_Connection {
    public static void main(String[] args) throws Exception {
        //1.注册驱动 异常盘出去(Exception全部的意思抛出去)
        //5.5版本以上可以不写
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //有异常回滚 try catch
        try {
            //开启事务
            conn.setAutoCommit(false);
            //5. 执行sql
            int count1 = stmt.executeUpdate(sql1);//受影响的行数
            //6. 处理结果
            System.out.println(count1);
            //异常 加入有异常不操作
            int i = 3/0;

            //5. 执行sql
            int count2 = stmt.executeUpdate(sql2);//受影响的行数
            //6. 处理结果
            System.out.println(count2);
            //提交事务
            conn.commit();
        } catch (Exception throwables) {
            //回滚事务
            conn.rollback();
            throwables.printStackTrace();
        }

        //提交事务

        //7. 释放资源
        stmt.close();
        conn.close();
    }
}
