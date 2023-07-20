package com.study.qqzone.dao;

import com.study.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * ClassName: UserBasicDAO
 * Package: com.study.qqzone.dao
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public interface UserBasicDAO {
    //根据账号和密码获取指定用户信息
    UserBasic getUserBasic(String loginId, String pwd);
    //获取指定用户的所有好友列表
    List<UserBasic> getUserBasicList(UserBasic userBasic);
    //根据id查询用户信息
    UserBasic getUserBasicById(Integer id);
}
