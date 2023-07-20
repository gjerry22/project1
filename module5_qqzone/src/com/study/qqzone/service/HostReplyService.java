package com.study.qqzone.service;

import com.study.qqzone.pojo.HostReply;

/**
 * ClassName: HostReplyService
 * Package: com.study.qqzone.service
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/7/3
 */
public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer id);
    void delHostReply(Integer id);
}
