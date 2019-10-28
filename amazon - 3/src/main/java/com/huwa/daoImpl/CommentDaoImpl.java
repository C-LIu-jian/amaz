package com.huwa.daoImpl;

import com.huwa.dao.CommentDao;
import com.huwa.entity.Comment;
import com.huwa.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 留言
 */
public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> commentAll() throws Exception {
        String sql="select * from  amz_comment order by create_time desc";
        QueryRunner qr=new QueryRunner(C3P0Util.getDs());
        return qr.query(sql,new BeanListHandler<Comment>(Comment.class));
    }

    @Override
    public int commentAdd(Comment comment) throws Exception {
        String sql="insert into amz_comment values(0,?,?,?,?,?,null) ";
        QueryRunner qr= new QueryRunner(C3P0Util.getDs());
        return   qr.update(sql,comment.getReply(),comment.getContent(), comment.getCreate_time(),
                comment.getReply_time(),comment.getNick_name());
    }
}
