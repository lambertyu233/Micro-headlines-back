package com.atguigu.service;

import com.atguigu.pojo.User;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 余俊超
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-08-16 13:35:25
*/
public interface UserService extends IService<User> {

    Result login(User user);

    //根据token获取用户数据
    Result getUserInfo(String token);
    //检查账号是否可用
    Result checkUserName(String username);
    //注册
    Result register(User user);
}
