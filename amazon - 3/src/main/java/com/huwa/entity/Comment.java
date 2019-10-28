package com.huwa.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 留言
 */
@Data
public class Comment {
    private  Long id;
    private String reply;
    private String content;
    private Date create_time;
    private Date reply_time;
    private String nick_name;
    private String state;

    public Comment() {
    }

    public Comment(String reply, String content, Date create_time, Date reply_time, String nick_name) {
        this.reply = reply;
        this.content = content;
        this.create_time = create_time;
        this.reply_time = reply_time;
        this.nick_name = nick_name;
    }
}
