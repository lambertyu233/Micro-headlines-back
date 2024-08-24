package com.atguigu.controller;

import com.atguigu.pojo.vo.PortalVo;
import com.atguigu.service.HeadlineService;
import com.atguigu.service.TypeService;
import com.atguigu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//http://localhost:8081/portal/search
@Controller
@RequestMapping("portal")
public class PortalController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;

    //查询所有标签
    @GetMapping("findAllTypes")
    @ResponseBody
    public Result findAllTypes(){
        Result result = typeService.findAllType();
        return result;
    }

//    @GetMapping("search")
//    public String search(){
//        return "search";
//    }

    //实现首页功能，显示标题及相关信息，并且实现后端分页功能
    @PostMapping("findNewsPage")
    @ResponseBody
    public Result findNewsPage(@RequestBody PortalVo portalVo){
//        System.out.println("portalVo = " + portalVo);
        if(portalVo.getPageNum()==""){
            portalVo.setPageNum("1");
        }
        if(portalVo.getPageSize()==""){
            portalVo.setPageSize("10");
        }
        Result result = headlineService.findNewsPage(portalVo);
        return result;
    }

    //点进标题展示文章内容
    @PostMapping("showHeadlineDetail")
    @ResponseBody
    public Result showHeadlineDetail(String hid){
        Result result = headlineService.showHeadlineDetail(hid);
        return result;
    }
}
