package com.lucifer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by zhangchuanqiang on 2017/3/3.
 */
public class JDBCTest2 {

    public static void main(String[] args){
        insert();
//            update();
//        delete();
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

    public static  void insert(){
        Connection conn=getConnection();
        try{
            String sql="INSERT INTO tbl_user(name,password,email)"+
                    "VALUES('Tom','123456','tom@163.com')";
            Statement st=conn.createStatement();
            int count=st.executeUpdate(sql);
            System.out.println("向表中插入了"+count+"条数据");
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 更新
     */
    public static void update(){
        Connection conn=getConnection();
        try{
            String sql="UPDATE tbl_user SET email='tom@126.com' WHERE name='Tom'";
            Statement st=conn.createStatement();
            int count=st.executeUpdate(sql);
            System.out.println("向表中更新了"+count+"条数据");
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void delete(){

        Connection conn=getConnection();
        try{
            String sql="DELETE FROM tbl_user  WHERE name='Tom'";

            Statement st=conn.createStatement();
            int count=st.executeUpdate(sql);
            System.out.println("向表中删除了"+count+"条数据");
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
