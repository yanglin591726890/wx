package com.zeroyoung.service.impl;

import com.zeroyoung.dao.UserMapper;
import com.zeroyoung.entity.User;
import com.zeroyoung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanglin on 2017/2/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByOpenId(String openid) throws Exception {

        return userMapper.findUserByOpenId(openid);
    }

    @Override
    public int SaveUser(User user) throws Exception {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUserByOpenId(String openId) throws Exception {
        return userMapper.deleteUserByOpenId(openId);
    }
}
