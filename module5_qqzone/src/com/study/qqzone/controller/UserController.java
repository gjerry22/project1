package com.study.qqzone.controller;

import com.study.qqzone.pojo.Topic;
import com.study.qqzone.pojo.UserBasic;
import com.study.qqzone.service.TopicService;
import com.study.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName: UserController
 * Package: com.study.qqzone.controller
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String pwd, HttpSession session) {
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if(userBasic != null) {
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            //userBasic保存的是登录者的信息
            //friend保存的是当前空间的主人
            session.setAttribute("userBasic", userBasic);
            session.setAttribute("friend", userBasic);
            return "index";
        } else {
            return "login";
        }
    }

    public String friend(Integer id, HttpSession session) {
        UserBasic currFriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currFriend);
        currFriend.setTopicList(topicList);
        session.setAttribute("friend", currFriend);
        return "index";
    }
}
