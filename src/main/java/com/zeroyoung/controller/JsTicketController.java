package com.zeroyoung.controller;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by yanglin on 2017/3/6.
 */
@Controller
@RequestMapping(value = "/ticket")
public class JsTicketController extends BaseController {
    @Autowired
    private WxMpService wxMpService;

    @RequestMapping(value = "/signature")
    public @ResponseBody
    WxJsapiSignature signature(String url){
        WxJsapiSignature jsapiSignature = null;
        try {
            jsapiSignature = wxMpService.createJsapiSignature(url);

            logger.info("url===>>>"+url);
            logger.info(jsapiSignature.getAppid());

        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return jsapiSignature;
    }
}
