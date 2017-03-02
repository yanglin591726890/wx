package com.zeroyoung.service;

import com.zeroyoung.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by yanglin on 2017/2/16.
 */
public interface UserService {

    public User findUserByOpenId(String openid)throws Exception;

    public int SaveUser(User user)throws Exception;

    public int deleteUserByOpenId(String openId) throws Exception;
}
