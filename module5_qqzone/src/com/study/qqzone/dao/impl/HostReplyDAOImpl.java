package com.study.qqzone.dao.impl;

import com.study.myssm.basedao.BaseDAO;
import com.study.qqzone.dao.HostReplyDAO;
import com.study.qqzone.pojo.HostReply;

/**
 * ClassName: HostReplyDAOImpl
 * Package: com.study.qqzone.dao.impl
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/7/3
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return load("select * from t_host_reply where reply=?", replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        super.executeUpdate("delete from t_host_reply where id=?", id);
    }
}
