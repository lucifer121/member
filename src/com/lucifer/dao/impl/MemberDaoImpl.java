package com.lucifer.dao.impl;

import com.lucifer.bean.MemberBean;
import com.lucifer.dao.MemberDao;
import com.lucifer.util.DateTransform;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangchuanqiang on 2017/4/6.
 */
public class MemberDaoImpl implements MemberDao {
    @Override
    public void insert(Connection conn, MemberBean memberBean) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO tbl_member(member_type,member_key,member_account,create_date)" +
                "VALUES (?,?,N?,?)");
       Date date= DateTransform.toSqlDate(memberBean.getCreate_data());
        ps.setString(1, memberBean.getMember_type());
        ps.setString(2, memberBean.getMember_key());
        ps.setString(3, memberBean.getMember_account());
        ps.setDate(4, date);
        int number=ps.executeUpdate();
        System.out.println("插入了"+number+"条数据");
    }

    @Override
    public String Search(Connection conn, String member_key,String member_type) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from tbl_member where member_key=? AND member_type= ?");
        ps.setString(1, member_key);
        ps.setString(2,member_type);
        ResultSet rs = ps.executeQuery();
        String memberAccount=null;
        while (rs.next()) {
//            System.out.print(rs.getString("member_account") + " ");
//            System.out.println();
            memberAccount=rs.getString("member_account");
        }
        return memberAccount;
    }

    @Override
    public void UpdateReceive(Connection conn, String member_key) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE tbl_member set receive='1' where member_key=?");
        ps.setString(1,member_key);
        ps.execute();
    }

    @Override
    public List<String> getCDkey(Connection conn, String type) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("select * from tbl_member where member_type= ? AND receive=?");
        ps.setString(1,type);
        ps.setString(2,"0");//未领取
        ResultSet rs = ps.executeQuery();
        List<String> cdKeys=new ArrayList<>();
        while (rs.next()) {
//            System.out.print(rs.getString("member_account") + " ");
//            System.out.println();
            cdKeys.add(rs.getString("member_key"));
        }
        return cdKeys;
    }
}
