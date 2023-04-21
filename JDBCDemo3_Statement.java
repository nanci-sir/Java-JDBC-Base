package com.nancijdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行DDL语句 执行完不一定有结果
 * @throws Exception
 */
public class JDBCDemo3_Statement {
    @Test
    public  void  testDDL() throws Exception {
        //1.注册驱动 异常盘出去(Exception全部的意思抛出去)
        //5.5版本以上可以不写
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql 是0但是执行成功
        String sql = "drop  database db2";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5. 执行sql
        int count = stmt.executeUpdate(sql);//执行完DDL语句，可能0
        //6. 处理结果
        System.out.println(count);

        //7. 释放资源
        stmt.close();
        conn.close();
    }


    /**
     * 执行DML语句
     * @throws Exception
     */

        @Test
        public  void  testDML() throws Exception {
            //1.注册驱动 异常盘出去(Exception全部的意思抛出去)
            //5.5版本以上可以不写
            //Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接
            String url = "jdbc:mysql:///db1?useSSL=false";
            String username = "root";
            String password = "root";
            Connection conn = DriverManager.getConnection(url, username, password);
            //3. 定义sql
            String sql = "update account set money = 4000 where id = 1";
            //4. 获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //5. 执行sql
            int count = stmt.executeUpdate(sql);//执行完DML语句，受影响的行数 0失败
            //6. 处理结果
            //System.out.println(count);
            if(count>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
            //7. 释放资源
            stmt.close();
            conn.close();
        }

}
