package com.zeroyoung.handler;

import com.zeroyoung.entity.User;
import com.zeroyoung.service.UserService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yanglin on 2017/1/17.
 */
@Component
public class SubscribeHandler extends AbstractHandler {
    @Autowired
    protected UserService userService;
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
        WxMpUser mpUser = wxMpService.getUserService().userInfo(wxMessage.getFromUser());

        WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content("可爱的"+mpUser.getNickname()+" 感谢您的关注!")
                .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                .build();

        try {
            userService.SaveUser(change(mpUser));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("关注事件:关注者："+wxMessage.getFromUser());
        return m;
    }

    private User change(WxMpUser mpUser){
        User u = new User();
        u.setCity(mpUser.getCity());
        u.setCountry(mpUser.getCountry());
        u.setGroupid(mpUser.getGroupId());
        u.setHeadimgurl(mpUser.getHeadImgUrl());
        u.setLanguage(mpUser.getLanguage());
        u.setNickname(mpUser.getNickname());
        u.setOpenid(mpUser.getOpenId());
        u.setProvince(mpUser.getProvince());
        u.setRemark(mpUser.getRemark());
        u.setSex(mpUser.getSex());
        u.setSexid(mpUser.getSexId());
        u.setSubscribe(mpUser.getSubscribe());
        u.setSubscribetime(mpUser.getSubscribeTime());
        u.setUnionid(mpUser.getUnionId());
        return u;
    }
}
