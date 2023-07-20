package com.study.qqzone.service;

import com.study.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * ClassName: UserBasicService
 * Package: com.study.qqzone.service
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public interface UserBasicService {
    UserBasic login(String loginId, String pwd);
    List<UserBasic> getFriendList(UserBasic userBasic);
    UserBasic getUserBasicById(Integer id);
}
