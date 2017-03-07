package com.zeroyoung.service;

import com.zeroyoung.entity.ShareCount;

/**
 * Created by yanglin on 2017/3/6.
 */
public interface ShareCountService {

    public int saveCount(ShareCount shareCount);

    public int countType(int pageid,String type);


    public int count(ShareCount shareCount);
}
