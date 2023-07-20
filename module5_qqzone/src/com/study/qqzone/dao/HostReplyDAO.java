package com.study.qqzone.dao;

import com.study.qqzone.pojo.HostReply;

/**
 * ClassName: HostReplyDAO
 * Package: com.study.qqzone.dao
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public interface HostReplyDAO {
    HostReply getHostReplyByReplyId(Integer id);
    void delHostReply(Integer id);
}
