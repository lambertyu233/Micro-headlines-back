package com.atguigu.service;

import com.atguigu.pojo.Headline;
import com.atguigu.pojo.vo.PortalVo;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 余俊超
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-08-16 13:35:25
*/
public interface HeadlineService extends IService<Headline> {

    Result findNewsPage(PortalVo portalVo);

    Result showHeadlineDetail(String hid);

    Result publish(Headline headline,String token);

    Result updateData(Headline headline);
}
