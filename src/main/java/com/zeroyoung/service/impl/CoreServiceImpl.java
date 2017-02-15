package com.zeroyoung.service.impl;

import com.zeroyoung.handler.*;
import com.zeroyoung.service.CoreService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by yanglin on 2017/1/17.
 */
@Service
public class CoreServiceImpl implements CoreService {
    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private LogHandler logHandler;
    @Autowired
    private SubscribeHandler subscribeHandler;
    @Autowired
    private TextCommonHandler textCommonHandler;
    @Autowired
    private ImageHandler imageHandler;
    @Autowired
    private VoiceHandler voiceHandler;
    @Autowired
    private LocationHandler locationHandler;
    @Autowired
    private VideoHandler videoHandler;


    protected Logger logger = LoggerFactory.getLogger(getClass());

    private WxMpMessageRouter router;


    @PostConstruct
    public void init() {
        this.refreshRouter();
    }

    @Override
    public void refreshRouter() {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(
                this.wxMpService);
        // 记录所有事件的日志
        newRouter.rule().handler(this.logHandler).next();
        // 关注事件
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
                .event(WxConsts.EVT_SUBSCRIBE).handler(this.subscribeHandler)
                .end();
        //文本消息
        newRouter.rule().async(false).msgType(WxConsts.CUSTOM_MSG_TEXT)
                .handler(this.textCommonHandler).end();
        //图片消息
        newRouter.rule().async(false).msgType(WxConsts.CUSTOM_MSG_IMAGE)
                .handler(this.imageHandler).end();

        //音频消息
        newRouter.rule().async(false).msgType(WxConsts.CUSTOM_MSG_VOICE)
                .handler(this.voiceHandler).end();
        //视频消息
        newRouter.rule().async(false).msgType(WxConsts.CUSTOM_MSG_VIDEO)
                .handler(this.videoHandler).end();

        //地理位置消息
        newRouter.rule().async(false).msgType(WxConsts.XML_MSG_LOCATION)
                .handler(this.locationHandler).end();

         this.router = newRouter;
    }

    @Override
    public WxMpXmlOutMessage route(WxMpXmlMessage inMessage) {
        try {
            return this.router.route(inMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }
        return null;
    }
}
