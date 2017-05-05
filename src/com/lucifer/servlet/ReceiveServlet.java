package com.lucifer.servlet;

import com.lucifer.dao.MemberDao;
import com.lucifer.dao.MemberMoreDao;
import com.lucifer.dao.impl.MemberDaoImpl;
import com.lucifer.dao.impl.MemberMoreDaoImpl;
import com.lucifer.util.ConnectionFactory;
import net.sf.json.JSONObject;

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
        req.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String CDkey=req.getParameter("CDkey");
        String typeId=req.getParameter("id");
        Connection conn= ConnectionFactory.getInstance().makeConnection();
        try{
            conn.setAutoCommit(false);
            MemberMoreDao memberMoreDao=new MemberMoreDaoImpl();
            String cdkey=memberMoreDao.queryCDkey(conn,typeId);
            conn.commit();
            if (cdkey!=null&&cdkey.equals(CDkey)){
                account=memberMoreDao.queryAccount(conn,typeId);
                conn.commit();
            }else{
                MemberDao memberDao=new MemberDaoImpl();
                account=memberDao.Search(conn,CDkey,typeId);
                conn.commit();
                if (account!=null){
                    memberDao.UpdateReceive(conn,CDkey);
                    conn.commit();
                }
            }
//            System.out.println(account);
        }catch (Exception e){
            try{
                conn.rollback();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        if (account!=null){
//            forword="/member/receiveSuccess.jsp";
//            req.setAttribute("account",account);
//            RequestDispatcher rd=req.getRequestDispatcher(forword);
//            rd.forward(req,response);
            StringBuffer str=new StringBuffer();
            str.append("{\"result\":\"success\",\"message\":\"获取成功！\"");
            str.append(",\"account\":\"");
            str.append(account);
            str.append("\"");
            str.append( "}");
            JSONObject object=JSONObject.fromObject(str.toString());
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().println(object);
        }else{
//            forword="/member/receiveFail.jsp";
//            RequestDispatcher rd=req.getRequestDispatcher(forword);
//            rd.forward(req,response);
            String str="{\"result\":\"fail\",\"message\":\"获取失败！\"}";
            JSONObject object=JSONObject.fromObject(str);
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().println(object);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
