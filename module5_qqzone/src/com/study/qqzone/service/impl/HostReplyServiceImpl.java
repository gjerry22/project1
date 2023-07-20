package com.study.qqzone.service.impl;

import com.study.qqzone.dao.HostReplyDAO;
import com.study.qqzone.pojo.HostReply;
import com.study.qqzone.service.HostReplyService;

/**
 * ClassName: HostReplyServiceImpl
 * Package: com.study.qqzone.service.impl
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/7/3
 */
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}
