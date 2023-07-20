package com.study.qqzone.dao;

import com.study.qqzone.pojo.Topic;
import com.study.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * ClassName: TopicDAO
 * Package: com.study.qqzone.dao
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public interface TopicDAO {
    //获取指定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    //添加日志
    void addTopic(Topic topic);
    //删除日志
    void delTopic(Integer id);
    //获取指定日志信息
    Topic getTopic(Integer id);
}
