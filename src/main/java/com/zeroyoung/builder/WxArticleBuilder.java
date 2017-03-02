package com.zeroyoung.builder;

import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;

/**
 * Created by yanglin on 2017/3/2.
 */
public class WxArticleBuilder {

    public static WxMpKefuMessage.WxArticle build(String url,String pic,String des,String title){
        WxMpKefuMessage.WxArticle article = new WxMpKefuMessage.WxArticle();
        article.setUrl(url);
        article.setPicUrl(pic);
        article.setDescription(des);
        article.setTitle(title);

        return article;
    }
}
