package com.zeroyoung.service;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * Created by yanglin on 2017/1/17.
 */
public interface CoreService {
    /**
     * 刷新消息路由器
     */
    void refreshRouter();

    /**
     * 路由消息
     *
     * @param inMessage
     * @return
     */
    WxMpXmlOutMessage route(WxMpXmlMessage inMessage);
}
