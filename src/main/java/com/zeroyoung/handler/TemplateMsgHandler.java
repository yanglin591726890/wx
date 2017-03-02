package com.zeroyoung.handler;

import com.zeroyoung.service.TemplateMsgService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yanglin on 2017/3/2.
 */
@Component
public class TemplateMsgHandler extends AbstractHandler {
    @Autowired
    private TemplateMsgService templateMsgService;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

        logger.info("demaxiyaa-------->>>>>>");

        switch (wxMessage.getEvent()){
            case "CLICK":
                try {
                    templateMsgService.sendTemplateMsgService(wxMessage.getFromUser());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case "TEMPLATESENDJOBFINISH":
                logger.info("发送的状态是:"+wxMessage.getStatus());
                break;
        }

        return null;
    }
}
