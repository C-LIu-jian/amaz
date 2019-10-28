package com.huwa.serviceImpl;

import com.huwa.dao.CommentDao;
import com.huwa.daoImpl.CommentDaoImpl;
import com.huwa.entity.Comment;
import com.huwa.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao;

    public CommentServiceImpl() {
        commentDao = new CommentDaoImpl();
    }

    @Override
    public List<Comment> commentAll() throws Exception {
        return commentDao.commentAll();
    }

    @Override
    public int commentAdd(Comment comment) throws Exception {
        return commentDao.commentAdd(comment);
    }
}
