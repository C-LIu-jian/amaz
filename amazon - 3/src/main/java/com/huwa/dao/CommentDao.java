package com.huwa.dao;

import com.huwa.entity.Comment;

import java.util.List;

public interface CommentDao {
    public List<Comment> commentAll() throws  Exception; //查询
    public int  commentAdd(Comment comment) throws  Exception ;//添加
}
