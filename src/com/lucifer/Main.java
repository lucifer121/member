package com.lucifer;

import com.lucifer.bean.MemberBean;
import com.lucifer.dao.MemberDao;
import com.lucifer.dao.impl.MemberDaoImpl;
import com.lucifer.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by zhangchuanqiang on 2017/4/6.
 */
public class Main {
    public static void main(String[] args ){
//        Connection conn= ConnectionFactory.getInstance().makeConnection();
//        try{
//            conn.setAutoCommit(false);
//            MemberDao memberDao=new MemberDaoImpl();
//
//            String account=memberDao.Search(conn,"lucifer");
//
//            conn.commit();
//            System.out.println(account);
//        }catch (Exception e){
//            try{
//                conn.rollback();
//            }catch (Exception e1){
//                e1.printStackTrace();
//            }
//        }
        insert();

    }
    public static void  insert(){
//        Connection conn= ConnectionFactory.getInstance().makeConnection();
//        String type="1";
//        String account="18253595300----1234567890";
//
//        MemberDao memberDao=new MemberDaoImpl();
//        MemberBean memberBean=new MemberBean();
//        memberBean.setMember_key(System.currentTimeMillis()+"");
//        memberBean.setMember_type(type);
//        memberBean.setMember_account(account);
//        memberBean.setCreate_data(new java.util.Date());
//
//        try{
//            conn.setAutoCommit(false);
//            memberDao.insert(conn,memberBean);
//            conn.commit();
//        }catch (Exception e){
//            try{
//                conn.rollback();
//            }catch (Exception e1){
//                e1.printStackTrace();
//            }
//        }
//
//        Connection conn=ConnectionFactory.getInstance().makeConnection();
//        try{
//            String sql="INSERT INTO tbl_member(member_type,member_key,member_account,create_date) VALUES ('1','14920','18253595300----1234567890','2017-04-13')";
//            Statement st=conn.createStatement();
//            int count=st.executeUpdate(sql);
//            System.out.println("向表中插入了"+count+"条数据");
//            conn.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
