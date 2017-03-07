package com.zeroyoung.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yanglin on 2017/3/3.
 */
@Controller
@RequestMapping(value = "/oauth")
public class OAuthController extends BaseController{
    @Autowired
    private WxMpService wxMpService;

    @RequestMapping(value = "weiOauth")
    public ModelAndView getUserInfo(String code){
        ModelAndView mv = new ModelAndView();

        WxMpUser wxMpUser = null;

        if(code!=null){
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
            try {
                wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
                wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken,null);

                logger.info("获取到用户信息"+wxMpUser);

            } catch (WxErrorException e) {
                e.printStackTrace();
            }
        }

        mv.addObject("user",wxMpUser);
        mv.setViewName("userinfo");

        return mv;
    }
}
