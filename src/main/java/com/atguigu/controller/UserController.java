package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.Result;
import com.atguigu.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
//http://localhost:8081/user
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;

//    @GetMapping()
//    public String login() {
//        return "login";
//    }

    //登录
    @PostMapping("login")
    @ResponseBody
    public Result login(@RequestBody User user) {
//        System.out.println("user = " + user);
        Result result = userService.login(user);
//        System.out.println("result = " + result);
        return result;
    }

    //根据token获取用户数据，用于已经登录后，在个人信息界面查看自己的相关数据
    @GetMapping("getUserInfo")
    @ResponseBody
    public Result getUserInfo(@RequestHeader String token) {
        Result result = userService.getUserInfo(token);
        return result;
    }

//    @GetMapping("register")
//    public String register() {
//        return "register";
//    }

    //注册
    @PostMapping("regist")
    @ResponseBody
    public Result register(@RequestBody User user) {
//        System.out.println("user = " + user);
        Result result = userService.register(user);
        return result;
    }

    //注册的时候检查用户名的唯一性
    @PostMapping("checkUserName")
    @ResponseBody
    public Result checkUserName(String username) {
//        System.out.println(username);
        Result result = userService.checkUserName(username);

        return result;
    }

    @GetMapping("checkLogin")
    @ResponseBody
    public Result checkLogin(@RequestHeader String token) {
//        System.out.println("token = " + token);
        boolean expiration = jwtHelper.isExpiration(token);
        if (expiration) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        return Result.ok(null);
    }
}
