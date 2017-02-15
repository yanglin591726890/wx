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
public class LocationHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT()
                .content("你的地理位置是：("+wxMessage.getLocationX()+","+wxMessage.getLocationY()+")")
                .toUser(wxMessage.getFromUser()).fromUser(wxMessage.getToUser()).build();

        logger.info("LocationHandler:用户发送了位置信息，("+wxMessage.getLocationX()+","+wxMessage.getLocationY()+")");
        return m;
    }
}
