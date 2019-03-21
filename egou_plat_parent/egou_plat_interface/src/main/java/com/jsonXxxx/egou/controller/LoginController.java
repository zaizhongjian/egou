package com.jsonXxxx.egou.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.jsonXxxx.egou.entity.User;
import com.jsonXxxx.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class LoginController {

    @PostMapping("/login")
    public Result findOne(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(true);
        subject.login(token);
        return Result.SUCCESS();
    }

}

