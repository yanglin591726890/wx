package com.zeroyoung.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yanglin on 2017/2/15.
 */
@Component
public class ImageHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        WxMpXmlOutImageMessage m = WxMpXmlOutMessage.IMAGE().mediaId(wxMessage.getMediaId())
                .toUser(wxMessage.getFromUser()).fromUser(wxMessage.getToUser()).build();
        logger.info("ImageHandler:图片maderid为："+wxMessage.getMediaId());
        return m;
    }
}
