package com.zeroyoung.builder;

import com.zeroyoung.config.MainConfig;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by yanglin on 2017/3/2.
 */
public class MenuBuilder {
    /**
     * 定义菜单结构
     *
     * @return
     */
    public static WxMenu getMenu(){

        MainConfig mainConfig = new MainConfig();
        WxMpService wxMpService = mainConfig.wxMpService();

        WxMenu menu = new WxMenu();
        WxMenuButton button1 = new WxMenuButton();
        button1.setName("功能1");

        WxMenuButton button11 = new WxMenuButton();
        button11.setType(WxConsts.BUTTON_CLICK);
        button11.setName("图文消息");
        button11.setKey("NEWS");

        WxMenuButton button12 = new WxMenuButton();
        button12.setType(WxConsts.BUTTON_CLICK);
        button12.setName("模板消息");
        button12.setKey("TEMPLATE");

        WxMenuButton button13 = new WxMenuButton();
        button13.setType(WxConsts.BUTTON_CLICK);
        button13.setName("用户信息");
        button13.setKey("USERINFO");


        button1.getSubButtons().add(button11);
        button1.getSubButtons().add(button12);
        button1.getSubButtons().add(button13);


        menu.getButtons().add(button1);

        return menu;

    }


}
