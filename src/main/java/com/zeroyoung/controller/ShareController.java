package com.zeroyoung.controller;

import com.zeroyoung.entity.PageShare;
import com.zeroyoung.service.PageShareService;
import com.zeroyoung.service.impl.PageShareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yanglin on 2017/3/6.
 */
@Controller
@RequestMapping(value = "/share")
public class ShareController extends BaseController {
    @Autowired
    private PageShareService pageShareService;


    @RequestMapping("pageShare")
    public ModelAndView pageShare(int id,String openid){

        PageShare page = null;

        ModelAndView modelAndView = new ModelAndView();

        if(openid!=null){
            modelAndView.addObject("openid",openid);
        }

        try {
            page = pageShareService.getPageShareById(id);
            modelAndView.addObject("page",page);
            modelAndView.setViewName(page.getLink());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

}
