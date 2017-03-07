package com.zeroyoung.service.impl;

import com.zeroyoung.dao.ShareCountMapper;
import com.zeroyoung.entity.ShareCount;
import com.zeroyoung.entity.ShareCountExample;
import com.zeroyoung.service.ShareCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanglin on 2017/3/6.
 */
@Service
public class ShareCountServiceImpl implements ShareCountService {
   @Autowired
   private ShareCountMapper shareCountMapper;

    @Override
    public int saveCount(ShareCount shareCount) {
        return shareCountMapper.insert(shareCount);
    }

    @Override
    public int countType(int pageid, String type) {
        ShareCountExample factory = factory(pageid, type);

        return shareCountMapper.countByExample(factory);
    }

    @Override
    public int count(ShareCount shareCount) {
        int i = shareCountMapper.updateCount(shareCount);

        return 0;
    }


    private ShareCountExample factory(int pageid, String type){
        ShareCountExample shareCountExample = new ShareCountExample();
        ShareCountExample.Criteria criteria = shareCountExample.createCriteria();
        criteria.andPageidEqualTo(pageid);

        if(type!=null){
            criteria.andSharetypeEqualTo(type);
        }

        return shareCountExample;
    }
}
