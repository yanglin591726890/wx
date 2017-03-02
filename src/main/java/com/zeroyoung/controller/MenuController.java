package com.zeroyoung.controller;

import com.zeroyoung.builder.MenuBuilder;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yanglin on 2017/3/2.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private WxMpService wxMpService;

    @RequestMapping(value = "menuCrate")
    public String menuCrate(){
        try {
            wxMpService.getMenuService().menuCreate(MenuBuilder.getMenu());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
