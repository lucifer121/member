package com.lucifer.servlet;

import com.lucifer.bean.MemberBean;
import com.lucifer.dao.MemberDao;
import com.lucifer.dao.impl.MemberDaoImpl;
import com.lucifer.util.ConnectionFactory;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

/**
 * Created by zhangchuanqiang on 2017/4/12.
 */
public class SaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Connection conn= ConnectionFactory.getInstance().makeConnection();
        String type=req.getParameter("type");
        String account=req.getParameter("account");
        account=account.trim();
        String[] accounts=account.split("\n");

        for (int i = 0; i < accounts.length; i++) {
            MemberDao memberDao=new MemberDaoImpl();
            MemberBean memberBean=new MemberBean();
            memberBean.setMember_key(UUID.randomUUID().toString());
            memberBean.setMember_type(type);
            memberBean.setMember_account(accounts[i]);
            memberBean.setCreate_data(new java.util.Date());

            try{
                conn.setAutoCommit(false);
                memberDao.insert(conn,memberBean);
                conn.commit();

            }catch (Exception e){
                try{
                    conn.rollback();
                    return;
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        }
        String str="{\"result\":\"success\",\"message\":\"成功！\"}";
        JSONObject object=JSONObject.fromObject(str);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.getWriter().println(object);

    }
}
