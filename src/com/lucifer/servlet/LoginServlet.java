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
        Connection conn= ConnectionFactory.getInstance().makeConnection();
        String type=req.getParameter("type");
        String account=req.getParameter("account");
        Date now = new Date();
        MemberDao memberDao=new MemberDaoImpl();
        MemberBean memberBean=new MemberBean();
        memberBean.setMember_key(""+System.currentTimeMillis());
        memberBean.setMember_type(type);
        memberBean.setMember_account(account);
        memberBean.setCreate_data(now);

        try{
            conn.setAutoCommit(false);
            memberDao.insert(conn,memberBean);
            System.out.println("向表中插入了"+1+"条数据");
            log("向表中插入了"+1+"条数");
        }catch (Exception e){
            try{
                conn.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
