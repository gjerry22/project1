package com.study.qqzone.service.impl;

import com.study.qqzone.dao.ReplyDAO;
import com.study.qqzone.pojo.HostReply;
import com.study.qqzone.pojo.Reply;
import com.study.qqzone.pojo.Topic;
import com.study.qqzone.pojo.UserBasic;
import com.study.qqzone.service.HostReplyService;
import com.study.qqzone.service.ReplyService;
import com.study.qqzone.service.UserBasicService;

import javax.print.DocFlavor;
import java.util.List;

/**
 * ClassName: ReplyServiceImpl
 * Package: com.study.qqzone.service.impl
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/7/3
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyListByTopicId(topicId);
        for(Reply reply : replyList) {
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer id) {
        HostReply hostReply = hostReplyService.getHostReplyByReplyId(id);
        if(hostReply != null) {
            hostReplyService.delHostReply(hostReply.getId());
        }
        replyDAO.delReply(id);
    }

    @Override
    public void delReplyByTopicId(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyListByTopicId(topicId);
        for(Reply reply: replyList) {
            delReply(reply.getId());
        }
    }

}
