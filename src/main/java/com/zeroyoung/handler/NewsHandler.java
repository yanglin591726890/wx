package com.zeroyoung.handler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by yanglin on 2017/3/2.
 */
@Component
public class NewsHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
        String key = wxMessage.getEventKey();
        WxMpXmlOutNewsMessage news = null;
        switch (key){
            case "USERINFO":
                String content = wxMpService.oauth2buildAuthorizationUrl(
                        "http://zeroyoung.viphk.ngrok.org/weixin/oauth/weiOauth"
                        , WxConsts.OAUTH2_SCOPE_USER_INFO,"");
                WxMpXmlOutNewsMessage.Item item = buildItem("来看看你的个人信息吧", "网页授权获取个人信息"
                        , content, "http://zeroyoung.viphk.ngrok.org/weixin/img/info.jpg");
                news = WxMpXmlOutNewsMessage.NEWS().addArticle(item)
                        .toUser(wxMessage.getFromUser()).fromUser(wxMessage.getToUser()).build();
                break;

            case "NEWS":
                news = buildNews(wxMessage);
                logger.info("发送了图文消息:"+news.getArticles());
                break;
        }

        return news;
    }

    private WxMpXmlOutNewsMessage buildNews(WxMpXmlMessage wxMessage){

        WxMpXmlOutNewsMessage.Item item1 = buildItem("第一个", "这是测试", "www.hao123.com",
                "http://zeroyoung.viphk.ngrok.org/weixin/img/te.jpg");


        WxMpXmlOutNewsMessage.Item item2 = buildItem("听过你是程序员", "to be or not to be ?",
                "http://zeroyoung.viphk.ngrok.org/weixin/share/pageShare?id=1", "http://zeroyoung.viphk.ngrok.org/weixin/img/fm.jpg");


        WxMpXmlOutNewsMessage.Item item3 = buildItem("what`s your favorit food ?", "fuck",
                "http://zeroyoung.viphk.ngrok.org/weixin/share/pageShare?id=2&openid="+wxMessage.getFromUser(),
                "http://zeroyoung.viphk.ngrok.org/weixin/img/food.jpg");


        WxMpXmlOutNewsMessage xmlOutNewsMessage = WxMpXmlOutNewsMessage.NEWS()
                .addArticle(item1).addArticle(item2).addArticle(item3)
                .toUser(wxMessage.getFromUser()).fromUser(wxMessage.getToUser()).build();
        return xmlOutNewsMessage;
    }


    private WxMpXmlOutNewsMessage.Item buildItem(String title,String des,String url,String pic){
        WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
        item.setTitle(title);
        item.setDescription(des);
        item.setPicUrl(pic);
        item.setUrl(url);

        return item;
    }
}
