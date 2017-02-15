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
 * Created by yanglin on 2017/1/17.
 */
@Component
public class SubscribeHandler extends AbstractHandler {

    /**
     * 处理关注消息的返回消息
     * @param wxMessage
     * @param context
     * @param wxMpService
     * @param sessionManager
     * @return
     * @throws WxErrorException
     */
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content("可爱的"+wxMessage.getFromUser()+" 感谢您的关注!")
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();
        logger.info("关注事件:关注者："+wxMessage.getFromUser());
        return m;
    }
}
