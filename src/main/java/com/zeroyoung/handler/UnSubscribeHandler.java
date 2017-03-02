package com.zeroyoung.handler;

import com.zeroyoung.service.UserService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yanglin on 2017/2/16.
 */
@Component
public class UnSubscribeHandler extends AbstractHandler {
    @Autowired
    private UserService userService;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        try {
            //从数据库中删除此人
            userService.deleteUserByOpenId(wxMessage.getFromUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
