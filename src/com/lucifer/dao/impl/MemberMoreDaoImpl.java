package com.lucifer.dao.impl;

import com.lucifer.bean.MemberBean;
import com.lucifer.dao.MemberMoreDao;
import com.lucifer.util.DateTransform;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhangchuanqiang on 2017/4/24.
 */
public class MemberMoreDaoImpl implements MemberMoreDao {

    @Override
    public void insert(Connection conn, MemberBean memberBean) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO tbl_member_more(member_type,member_account,create_date)" +
                "VALUES (?,?,N?)");
        Date date = DateTransform.toSqlDate(memberBean.getCreate_data());
        ps.setString(1, memberBean.getMember_type());
        ps.setString(2, memberBean.getMember_account());
        ps.setDate(3, date);
        int number = ps.executeUpdate();
        System.out.println("插入了" + number + "条数据");
    }

    /**
     * @param conn
     * @param typeId     账号类型 ？爱奇艺：其他
     * @param key
     * @param updateDate
     * @throws SQLException
     */
    @Override
    public void update(Connection conn, String typeId, String key, java.util.Date updateDate) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("REPLACE INTO tbl_keys(member_type,member_key,update_date)" +
                "VALUES (?,?,?)");
        Date date = DateTransform.toSqlDate(updateDate);
        ps.setString(1, typeId);
        ps.setString(2, key);
        ps.setDate(3, date);
        int number = ps.executeUpdate();
        System.out.println("更新" + number + "条数据");
    }

    @Override
    public String queryAccount(Connection conn, String member_type) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("select * from tbl_member_more where member_type= ?");
        ps.setString(1, member_type);
        ResultSet rs = ps.executeQuery();
        List<String> memberAccount = new ArrayList<>();
        while (rs.next()) {
            memberAccount.add(rs.getString("member_account"));
        }
        Random random = new Random();
        int number = random.nextInt(memberAccount.size());
        return memberAccount.get(number);
    }

    @Override
    public String queryCDkey(Connection conn, String member_type) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from tbl_keys where member_type= ?");
        ps.setString(1, member_type);
        ResultSet rs = ps.executeQuery();
        String key = "";
        while (rs.next()) {
            key=rs.getString("member_key");
        }
        return key;
    }
}
