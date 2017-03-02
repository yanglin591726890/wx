package com.zeroyoung.service.impl;

import com.zeroyoung.service.TemplateMsgService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yanglin on 2017/3/2.
 */
@Service
public class TemplateMsgServiceImpl implements TemplateMsgService {
    @Autowired
    protected WxMpService wxMpService;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public int sendTemplateMsgService(String openid) throws Exception {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setUrl("www.hao123.com");
        wxMpTemplateMessage.setTemplateId("_DvYpyB3HExMrC-8T7cJFIBpRYacaAhV2S8OqftYR04");
        wxMpTemplateMessage.setToUser(openid);
        wxMpTemplateMessage.addWxMpTemplateData(new WxMpTemplateData("first","小店收到您的货款，本店将马上为您配货，请耐心等待！","#32CD32"));
        wxMpTemplateMessage.addWxMpTemplateData(new WxMpTemplateData("orderMoneySum","50.00","#ff0000"));
        wxMpTemplateMessage.addWxMpTemplateData(new WxMpTemplateData("orderProductName","德芙巧克力","#173177"));
        wxMpTemplateMessage.addWxMpTemplateData(new WxMpTemplateData("Remark","欢迎再次购买！","#00ff00"));
        String s = wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        logger.info("发送模板消息!---"+s);
        return 0;
    }
}
