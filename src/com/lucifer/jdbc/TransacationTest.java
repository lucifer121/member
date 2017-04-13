package com.lucifer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by zhangchuanqiang on 2017/3/9.
 */
public class TransacationTest {
    public static void main(String[] args){

    }
    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","");

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void insertUserInfo(){
        Connection conn=getConnection();
        try{
            String sql="INSERT INTO tbl_user(id,name,password,email)"+
                    "VALUES(10,'tom','123456','tom@163.com)'";
            Statement st=conn.createStatement();
            int count=st.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
