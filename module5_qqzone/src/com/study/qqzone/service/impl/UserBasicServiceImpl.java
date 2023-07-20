package com.study.qqzone.service.impl;

import com.study.qqzone.dao.UserBasicDAO;
import com.study.qqzone.pojo.UserBasic;
import com.study.qqzone.service.UserBasicService;

import java.util.List;

/**
 * ClassName: UserBasicServiceImpl
 * Package: com.study.qqzone.service.impl
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDAO userBasicDAO;

    @Override
    public UserBasic login(String loginId, String pwd) {
        return userBasicDAO.getUserBasic(loginId, pwd);
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        return userBasicList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return userBasicDAO.getUserBasicById(id);
    }
}
