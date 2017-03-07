package com.zeroyoung.service.impl;

import com.zeroyoung.dao.PageShareMapper;
import com.zeroyoung.entity.PageShare;
import com.zeroyoung.service.PageShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanglin on 2017/3/6.
 */

@Service
public class PageShareServiceImpl implements PageShareService {
    @Autowired
    private PageShareMapper pageShareMapper;

    @Override
    public PageShare getPageShareById(int id) throws Exception {
        return pageShareMapper.selectByPrimaryKey(id);
    }
}
