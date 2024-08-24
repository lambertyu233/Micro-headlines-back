package com.atguigu.controller;

import com.atguigu.pojo.Headline;
import com.atguigu.service.HeadlineService;
import com.atguigu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("headline")
public class HeadlineController {

    @Autowired
    private HeadlineService headlineService;

//    @GetMapping
//    public String index(){
//        return "index";
//    }

    //头条内容发布
    @PostMapping("publish")
    @ResponseBody
    public Result publish(@RequestBody Headline headline,@RequestHeader String token) {
//        System.out.println("headline = " + headline + ", token = " + token);
        Result result = headlineService.publish(headline,token);
        return result;
    }

    //头条内容修改回显
    @PostMapping("findHeadlineByHid")
    @ResponseBody
    public Result findHeadlineByHid(String hid){
//        System.out.println("hid = " + hid);
        Headline headline = headlineService.getById(hid);
        Map data = new HashMap();
        data.put("headline", headline);
        return Result.ok(data);
    }

    //头条内容修改
    @PostMapping("update")
    @ResponseBody
    public Result update(@RequestBody Headline headline){
//        System.out.println("headline = " + headline);
        Result result = headlineService.updateData(headline);
        return result;
    }

    //头条内容删除
    @PostMapping("removeByHid")
    @ResponseBody
    public Result removeByHid(String hid){
//        System.out.println("hid = " + hid);
        headlineService.removeById(hid);
        return Result.ok(null);
    }
}
