package com.zeroyoung.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanglin on 2017/1/17.
 */
@Configuration
public class MainConfig {

    @Value("#{wxProperties.appid}")
    private String appid;

    @Value("#{wxProperties.appsecret}")
    private String appsecret;

    @Value("#{wxProperties.token}")
    private String token;

    @Value("#{wxProperties.aeskey}")
    private String aesKey;

    @Value("#{wxProperties.partener_id}")
    private String partenerId;

    @Value("#{wxProperties.partener_key}")
    private String partenerKey;

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
        configStorage.setAppId(this.appid);
        configStorage.setSecret(this.appsecret);
        configStorage.setToken(this.token);
        configStorage.setAesKey(this.aesKey);
        configStorage.setPartnerId(this.partenerId);
        configStorage.setPartnerKey(this.partenerKey);
        return configStorage;
    }

    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

}

