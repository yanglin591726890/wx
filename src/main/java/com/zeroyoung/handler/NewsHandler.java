package com.zeroyoung.handler;

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
        WxMpXmlOutNewsMessage news = buildNews(wxMessage);
        logger.info("发送了图文消息:"+news.getArticles());
        return news;
    }

    private WxMpXmlOutNewsMessage buildNews(WxMpXmlMessage wxMessage){
        WxMpXmlOutNewsMessage.Item item2 = buildItem("第二个", "这是测试", "www.hao123.com", "http://zeroyoung.viphk.ngrok.org/weixin/img/1.jpg");
        WxMpXmlOutNewsMessage.Item item1 = buildItem("第一个", "fuck", "www.baidu.com", "http://zeroyoung.viphk.ngrok.org/weixin/img/te.jpg");
        WxMpXmlOutNewsMessage.Item item3 = buildItem("第三个", "fuck", "www.baidu.com", "http://zeroyoung.viphk.ngrok.org/weixin/img/2.jpg");
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
