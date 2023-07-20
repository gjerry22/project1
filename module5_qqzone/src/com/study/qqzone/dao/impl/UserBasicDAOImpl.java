package com.study.qqzone.dao.impl;

import com.study.myssm.basedao.BaseDAO;
import com.study.qqzone.dao.UserBasicDAO;
import com.study.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * ClassName: UserBasicDAOImpl
 * Package: com.study.qqzone.dao.impl
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/6/30
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select * from t_user_basic where loginId=? and pwd=?", loginId, pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql = "select * from t_user_basic where id in (select fid from t_friend where uid=?)";
        return super.executeQuery(sql, userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return super.load("select * from t_user_basic where id=?", id);
    }
}
