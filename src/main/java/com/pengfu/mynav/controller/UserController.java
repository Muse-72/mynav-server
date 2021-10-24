package com.pengfu.mynav.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pengfu.mynav.model.vo.UserVo;
import com.pengfu.mynav.service.UserService;
import com.pengfu.mynav.util.Result;
import com.pengfu.mynav.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author PrideZH
 * @date 2021/10/22 - 22:49
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestParam("token") String token) {
        return Result.build(ResultCode.FAIL);
    }

    @PostMapping("/register")
    public Result register(@RequestBody String dataJson) {
        // 获取参数
        JSONObject data = JSON.parseObject(dataJson);
        String username = data.getString("username");
        String password = data.getString("password");

        // 参数判断
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return Result.build(ResultCode.PARAM_IS_LACK);
        }

        // 判断是否已被注册
        if (userService.findByUsername(username) != null) {
            return Result.build(ResultCode.FAIL, "用户名存在");
        }

        // 用户注册
        UserVo userVo = userService.register(username, password);
        if (userVo != null) {
            return Result.build(ResultCode.SUCCESS, "注册成功", userVo);
        } else {
            return Result.build(ResultCode.FAIL, "注册失败");
        }
    }

    @PostMapping("login")
    public Result login(@RequestBody String dataJson) {
        // 获取参数
        JSONObject data = JSON.parseObject(dataJson);
        String username = data.getString("username");
        String password = data.getString("password");

        // 参数判断
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return Result.build(ResultCode.PARAM_IS_LACK);
        }

        // 用户登录
        UserVo userVo = userService.login(username, password);
        if (userVo != null) {
            return Result.build(ResultCode.SUCCESS, "登录成功", userVo);
        }
        return Result.build(ResultCode.FAIL, "账号或密码错误");
    }

}
