package com.study.qqzone.service.impl;

import com.study.qqzone.dao.TopicDAO;
import com.study.qqzone.pojo.Reply;
import com.study.qqzone.pojo.Topic;
import com.study.qqzone.pojo.UserBasic;
import com.study.qqzone.service.ReplyService;
import com.study.qqzone.service.TopicService;
import com.study.qqzone.service.UserBasicService;

import java.util.List;

/**
 * ClassName: TopicSeviveImpl
 * Package: com.study.qqzone.service.impl
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO;
    private ReplyService replyService;
    private UserBasicService userBasicService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        UserBasic author = userBasicService.getUserBasicById(topic.getAuthor().getId());
        topic.setAuthor(author);
        List<Reply> replyList = replyService.getReplyListByTopicId(id);
        topic.setReplyList(replyList);

        return topic;
    }

    @Override
    public void delTopic(Integer id) {
        replyService.delReplyByTopicId(id);
        topicDAO.delTopic(id);
    }
}
