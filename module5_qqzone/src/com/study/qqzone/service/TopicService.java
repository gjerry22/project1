package com.study.qqzone.service;

import com.study.qqzone.pojo.Topic;
import com.study.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * ClassName: TopicService
 * Package: com.study.qqzone.service
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public interface TopicService {
    //查询指定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    Topic getTopicById(Integer id);
    void delTopic(Integer id);
}
