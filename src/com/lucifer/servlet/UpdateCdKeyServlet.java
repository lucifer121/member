package com.lucifer.servlet;

import com.lucifer.dao.MemberMoreDao;
import com.lucifer.dao.impl.MemberMoreDaoImpl;
import com.lucifer.util.ConnectionFactory;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

/**
 * Created by zhangchuanqiang on 2017/4/24.
 */
public class UpdateCdKeyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String type=req.getParameter("type");
        String cdKey=req.getParameter("key");
        Connection conn= ConnectionFactory.getInstance().makeConnection();
        try{
            conn.setAutoCommit(false);
            MemberMoreDao memberMoreDao=new MemberMoreDaoImpl();
            memberMoreDao.update(conn,type,cdKey,new Date());
            conn.commit();
        }catch (Exception e){
            try{
                conn.rollback();
                String str="{\"result\":\"fail\",\"message\":\"失败！\"}";
                JSONObject object=JSONObject.fromObject(str);
                resp.setHeader("Access-Control-Allow-Origin", "*");
                resp.getWriter().println(object);
                return;
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        String str="{\"result\":\"success\",\"message\":\"成功！\"}";
        JSONObject object=JSONObject.fromObject(str);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.getWriter().println(object);
    }
}
