package com.lucifer.bean;

import java.util.Date;

/**
 * Created by zhangchuanqiang on 2017/4/6.
 * id int(11) unsigned not null auto_increment,
 member_type VARCHAR(20) not null default "",
 member_key  VARCHAR(20) not null default "",
 member_account VARCHAR(100) not null default "",
 create_date DATE,
 receive bool not null default false,
 receive_date DATE,
 */
public class MemberBean {
    private int id;
    private String member_key;
    private String member_type;
    private String member_account;
    private Date create_data;
    private boolean receive;
    private Date receive_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMember_key() {
        return member_key;
    }

    public void setMember_key(String member_key) {
        this.member_key = member_key;
    }

    public String getMember_type() {
        return member_type;
    }

    public void setMember_type(String member_type) {
        this.member_type = member_type;
    }

    public String getMember_account() {
        return member_account;
    }

    public void setMember_account(String member_account) {
        this.member_account = member_account;
    }

    public Date getCreate_data() {
        return create_data;
    }

    public void setCreate_data(Date create_data) {
        this.create_data = create_data;
    }

    public boolean isReceive() {
        return receive;
    }

    public void setReceive(boolean receive) {
        this.receive = receive;
    }

    public Date getReceive_date() {
        return receive_date;
    }

    public void setReceive_date(Date receive_date) {
        this.receive_date = receive_date;
    }
}
