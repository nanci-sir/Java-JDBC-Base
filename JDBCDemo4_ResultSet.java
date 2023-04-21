package com.nancijdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ResultSet
 */
public class JDBCDemo4_ResultSet {
    @Test
    public  void  testResultSet() throws Exception {
        //1.注册驱动 异常盘出去(Exception全部的意思抛出去)
        //5.5版本以上可以不写
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3.定义sql
        String sql = "select * from account";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5. 执行sql 查询
        ResultSet rs = stmt.executeQuery(sql);
        //6. 处理结果
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            //6.2 获取数据  getXxx()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println("--------------");
        }

        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


}
