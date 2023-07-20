package com.study.qqzone.dao.impl;

import com.study.myssm.basedao.BaseDAO;
import com.study.qqzone.dao.ReplyDAO;
import com.study.qqzone.pojo.Reply;
import com.study.qqzone.pojo.Topic;

import java.util.List;

/**
 * ClassName: ReplyDAOImpl
 * Package: com.study.qqzone.dao.impl
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/7/3
 */
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        return executeQuery("select * from t_reply where topic=?", topicId);
    }

    @Override
    public void addReply(Reply reply) {
        executeUpdate("insert into t_reply values(0,?,?,?,?)", reply.getContent(), reply.getReplyDate(), reply.getAuthor().getId(), reply.getTopic().getId());
    }

    @Override
    public void delReply(Integer id) {
        executeUpdate("delete from t_reply where id=?", id);
    }

    @Override
    public Reply getReply(Integer id) {
        return load("select * from t_reply where id=?", id);
    }
}
