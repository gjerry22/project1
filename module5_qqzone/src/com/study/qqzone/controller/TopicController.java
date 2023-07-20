package com.study.qqzone.controller;

import com.study.qqzone.pojo.Reply;
import com.study.qqzone.pojo.Topic;
import com.study.qqzone.pojo.UserBasic;
import com.study.qqzone.service.ReplyService;
import com.study.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName: TOpicController
 * Package: com.study.qqzone.controller
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/7/3
 */
public class TopicController {
    private TopicService topicService;

    public String topicDetail(Integer id, HttpSession session) {
        Topic topic = topicService.getTopicById(id);
        session.setAttribute("topic", topic);
        return "frames/detail";
    }
    public String delTopic(Integer topicId ,HttpSession session) {
        topicService.delTopic(topicId);
        UserBasic friend = (UserBasic) session.getAttribute("friend");  //只能等于userBasic
        List<Topic> topicList = topicService.getTopicList(friend);
        friend.setTopicList(topicList);
        session.setAttribute("friend", friend);
        return "frames/main";
    }
}
