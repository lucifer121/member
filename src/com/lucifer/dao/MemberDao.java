package com.lucifer.dao;

import com.lucifer.bean.MemberBean;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zhangchuanqiang on 2017/4/6.
 */
public interface MemberDao {
    /**
     * 插入账号
     * @param connection
     * @param memberBean
     * @throws SQLException
     */
    public void insert(Connection connection, MemberBean memberBean) throws SQLException;

    /**
     * 获取账号
     * @param connection
     * @param member_key
     * @return
     * @throws SQLException
     */
    public String Search(Connection connection, String member_key) throws SQLException;

    /**
     * 更新数据库 中该账户已经被领取
     * @param connection
     * @param member_key
     * @throws SQLException
     */
    public void UpdateReceive(Connection connection,String member_key) throws SQLException;


}
