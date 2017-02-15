package com.zeroyoung.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yanglin on 2017/2/15.
 */
@Component
public class VoiceHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        WxMpXmlOutTextMessage message = WxMpXmlOutMessage.TEXT().content("你发送的语言消息转化为文字是：\n"+wxMessage.getRecognition())
                .toUser(wxMessage.getFromUser()).fromUser(wxMessage.getToUser()).build();
        logger.info("VoiceHandler:发送的语言消息：内容为："+wxMessage.getRecognition());
        return message;
    }
}
