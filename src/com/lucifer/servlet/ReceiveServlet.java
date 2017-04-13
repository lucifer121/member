package com.lucifer.servlet;

import com.lucifer.dao.MemberDao;
import com.lucifer.dao.impl.MemberDaoImpl;
import com.lucifer.util.ConnectionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by zhangchuanqiang on 2017/4/6.
 */
public class ReceiveServlet extends HttpServlet {
    String account=null;
    String forword=null;
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String CDkey=req.getParameter("CDkey");
        System.out.println("提取码====="+CDkey);
        Connection conn= ConnectionFactory.getInstance().makeConnection();
        try{
            conn.setAutoCommit(false);
            MemberDao memberDao=new MemberDaoImpl();

            account=memberDao.Search(conn,CDkey);
            conn.commit();
            if (account!=null){
                memberDao.UpdateReceive(conn,CDkey);
                conn.commit();
            }
            System.out.println(account);
        }catch (Exception e){
            try{
                conn.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        if (account!=null){
            forword="/member/receiveSuccess.jsp";
            req.setAttribute("account",account);
            RequestDispatcher rd=req.getRequestDispatcher(forword);
            rd.forward(req,response);

        }else{
            forword="/member/receiveFail.jsp";
            RequestDispatcher rd=req.getRequestDispatcher(forword);
            rd.forward(req,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
