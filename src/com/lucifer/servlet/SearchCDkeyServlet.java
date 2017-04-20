package com.lucifer.servlet;

import com.lucifer.bean.MemberBean;
import com.lucifer.dao.MemberDao;
import com.lucifer.dao.impl.MemberDaoImpl;
import com.lucifer.util.ConnectionFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhangchuanqiang on 2017/4/14.
 */
public class SearchCDkeyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Connection conn = ConnectionFactory.getInstance().makeConnection();
        String type = req.getParameter("type");
        MemberDao memberDao = new MemberDaoImpl();
        List<String> keys=new ArrayList<>();
        try {
            conn.setAutoCommit(false);
             keys = memberDao.getCDkey(conn, type);
            conn.commit();

        } catch (Exception e) {
            try {
                conn.rollback();
                return;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        JSONArray jsonarray = JSONArray.fromObject(keys);
        String str = "{\"result\":\"success\",\"message\":\"成功！\"}";
//        JSONObject object = JSONObject.fromObject(str);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.getWriter().println(jsonarray.toString());


    }
}
