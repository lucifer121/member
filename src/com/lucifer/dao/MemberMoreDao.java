package com.lucifer.dao;

import com.lucifer.bean.MemberBean;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

/**
 * Created by zhangchuanqiang on 2017/4/24.
 */
public interface MemberMoreDao {
    /**
     * 插入账号
     * @param connection
     * @param memberBean
     * @throws SQLException
     */
    void insert(Connection connection, MemberBean memberBean) throws SQLException;

    /**
     *  修改领取码
     * @param conn
     * @param typeId  账号类型 ？爱奇艺：其他
     * @param password 修改的领取码
     * @throws SQLException
     */
    void update(Connection conn, String typeId, String password, Date updateDate) throws SQLException;

    String queryAccount(Connection conn,String member_type) throws SQLException;

    String queryCDkey(Connection conn,String member_type) throws SQLException;
}
