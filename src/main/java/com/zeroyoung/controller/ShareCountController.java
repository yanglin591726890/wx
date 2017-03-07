package com.zeroyoung.controller;

import com.sun.scenario.effect.impl.prism.PrImage;
import com.zeroyoung.entity.ShareCount;
import com.zeroyoung.service.ShareCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanglin on 2017/3/6.
 */
@Controller
@RequestMapping(value = "shareCount")
public class ShareCountController extends BaseController {
    @Autowired
    private ShareCountService shareCountService;

    @RequestMapping(value = "count")
    public @ResponseBody String count(@RequestBody ShareCount count){

        shareCountService.count(count);
        logger.info(count.toString());

        return "ok";
    }

    @RequestMapping("addPage")
    public String addPage(){

        ShareCount qq = getShareCount("QQ");
        ShareCount appMessage = getShareCount("appMessage");
        ShareCount timeLine = getShareCount("timeLine");
        ShareCount weibo = getShareCount("weibo");
        ShareCount qZone = getShareCount("QZone");

        shareCountService.saveCount(qq);
        shareCountService.saveCount(appMessage);
        shareCountService.saveCount(timeLine);
        shareCountService.saveCount(weibo);
        shareCountService.saveCount(qZone);

        return "index";
    }


    private ShareCount getShareCount(String type){
        ShareCount shareCount = new ShareCount();

        shareCount.setCtime(System.currentTimeMillis());
        shareCount.setCount(0l);
        shareCount.setPageid(2);
        shareCount.setSharetype(type);

        return shareCount;
    }



    @RequestMapping(value = "countPage")
    public  String count(){
        ShareCount shareCount = new ShareCount();

        shareCount.setCtime(System.currentTimeMillis());
        shareCount.setPageid(1);
        shareCount.setSharetype("QQ");

        return "index";
    }
}
