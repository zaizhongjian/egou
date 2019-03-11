package com.jsonXxxx.egou.controller;

import com.jsonXxxx.egou.entity.User;
import com.jsonXxxx.util.Result;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class LoginController {

    @PostMapping("/find")
    public Result findOne(@RequestBody User user) {
        if ("jinxu".equals(user.getName()) && "123".equals(user.getPassword())) {
            return Result.SUCCESS().addMsg("登陆成功");
        }
        return Result.ERROR().addMsg("登陆失败");
    }

    @GetMapping("/index")
    public String get() {
        return "aaaaaaaa";
    }
}

