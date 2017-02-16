package com.zeroyoung.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yanglin on 2017/2/15.
 */
@Component
public class TextCommonHandler extends  AbstractHandler {
    /**
     * 基本文字信息的处理
     * @param wxMessage
     * @param context
     * @param wxMpService
     * @param sessionManager
     * @return
     * @throws WxErrorException
     */
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content("感谢您发送文字消息，\n，内容为："+wxMessage.getContent())
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
        logger.info("TextCommonHandler:"+m.getContent());
        WxMpKefuMessage mpKefuMessage = WxMpKefuMessage.TEXT().content("nihao").toUser(wxMessage.getFromUser()).build();
        wxMpService.getKefuService().sendKefuMessage(mpKefuMessage);
        return m;
    }
}
