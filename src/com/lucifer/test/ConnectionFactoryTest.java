package com.lucifer.test;

import com.lucifer.util.ConnectionFactory;

import java.sql.Connection;

/**
 * Created by zhangchuanqiang on 2017/3/9.
 */
public class ConnectionFactoryTest {

    public static void main(String[] args) throws Exception{
        ConnectionFactory cf=ConnectionFactory.getInstance();
        Connection conn=cf.makeConnection();
        System.out.println(conn.getAutoCommit());

    }
}
