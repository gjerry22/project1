package com.study.qqzone.dao.impl;

import com.study.myssm.basedao.BaseDAO;
import com.study.qqzone.dao.TopicDAO;
import com.study.qqzone.pojo.Topic;
import com.study.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * ClassName: TopicDAOImpl
 * Package: com.study.qqzone.dao.impl
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author=?", userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopic(Integer id) {
        executeUpdate("delete from t_topic where id=?", id);
    }

    @Override
    public Topic getTopic(Integer id) {
        return load("select * from t_topic where id=?", id);
    }
}
