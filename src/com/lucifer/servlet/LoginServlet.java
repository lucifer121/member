package com.lucifer.servlet;

import com.lucifer.bean.MemberBean;
import com.lucifer.dao.MemberDao;
import com.lucifer.dao.impl.MemberDaoImpl;
import com.lucifer.util.ConnectionFactory;
import com.sun.tools.javac.util.Log;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.UUID;

/**
 * Created by zhangchuanqiang on 2017/3/10.
 */


public class LoginServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userName=req.getParameter("uname");
//        String password=req.getParameter("upwd");
//
//        System.out.println("用户名是====="+userName);
//        System.out.println("密码是====="+password);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        
    }
}
