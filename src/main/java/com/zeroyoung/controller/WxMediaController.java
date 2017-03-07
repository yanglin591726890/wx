package com.zeroyoung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yanglin on 2017/3/6.
 */
@Controller
@RequestMapping(value = "media")
public class WxMediaController extends BaseController {


    @RequestMapping(value="add")
    public @ResponseBody String add(@RequestBody HashMap<String,Object> map){

        String type =  map.get("mediaType").toString();
        String openid = map.get("openid").toString();
        ArrayList<String> media_id = (ArrayList<String>) map.get("imgs");


        logger.info(openid);
        logger.info(media_id.get(0));
        logger.info(media_id.get(1));
        logger.info(media_id.get(2));

        return "";
    }

}
