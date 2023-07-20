package com.study.qqzone.dao;

import com.study.qqzone.pojo.Reply;
import com.study.qqzone.pojo.Topic;

import java.util.List;

/**
 * ClassName: ReplyDAO
 * Package: com.study.qqzone.dao
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplyListByTopicId(Integer topicId);
    //添加回复
    void addReply(Reply reply);
    //删除日志
    void delReply(Integer id);
    Reply getReply(Integer id);
}
