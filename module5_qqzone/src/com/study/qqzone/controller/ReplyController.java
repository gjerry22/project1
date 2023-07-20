package com.study.qqzone.controller;

import com.study.qqzone.pojo.Reply;
import com.study.qqzone.pojo.Topic;
import com.study.qqzone.pojo.UserBasic;
import com.study.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * ClassName: ReplyController
 * Package: com.study.qqzone.controller
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/7/3
 */
public class ReplyController {
    private ReplyService replyService;

    public String addReply(String content, Integer topicId, HttpSession session) {
        UserBasic author = (UserBasic)session.getAttribute("userBasic");
        Reply reply = new Reply(content, new Date(), author, new Topic(topicId));
        replyService.addReply(reply);

        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }

    public String delReply(Integer replyId, HttpSession session) {
        replyService.delReply(replyId);
//        System.out.println(session.getAttribute("topicId"));
        Topic topic = (Topic) session.getAttribute("topic");
        return "redirect:topic.do?operate=topicDetail&id=" + topic.getId();
    }
}
