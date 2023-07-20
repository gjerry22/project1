package com.study.qqzone.service;

import com.study.qqzone.pojo.Reply;

import java.util.List;

/**
 * ClassName: ReplyService
 * Package: com.study.qqzone.service
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/7/3
 */
public interface ReplyService {
    //获取topicId关联的所有回复
    List<Reply> getReplyListByTopicId(Integer topicId);
    void addReply(Reply reply);
    void delReply(Integer id);
    void delReplyByTopicId(Integer topicId);
}
