package com.pengfu.mynav.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pengfu.mynav.model.dto.UserDTO;
import com.pengfu.mynav.model.vo.UserVO;
import com.pengfu.mynav.service.UserService;
import com.pengfu.mynav.util.Result;
import com.pengfu.mynav.util.ResultCode;
import com.pengfu.mynav.util.ServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author PrideZH
 * @date 2021/10/22 - 22:49
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<UserDTO> register(@RequestBody UserVO userVO) {
        // 参数判断
        if (StringUtils.isEmpty(userVO.getUsername()) || StringUtils.isEmpty(userVO.getPassword())) {
            return Result.build(ResultCode.PARAM_IS_LACK);
        }

        try {
            UserDTO userDTO = userService.register(userVO.getUsername(), userVO.getPassword());
            return Result.build(ResultCode.SUCCESS, "注册成功", userDTO);
        } catch (ServiceException e) {
            return Result.build(ResultCode.FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultCode.ERROR);
        }
    }

    @ApiOperation("用户登录")
    @PostMapping("login")
    public Result<UserDTO> login(@RequestBody UserVO userVO) {
        // 参数判断
        if (StringUtils.isEmpty(userVO.getUsername()) || StringUtils.isEmpty(userVO.getPassword())) {
            return Result.build(ResultCode.PARAM_IS_LACK);
        }

        // 用户登录
        UserDTO userDTO = userService.login(userVO.getUsername(), userVO.getPassword());
        if (userDTO != null) {
            return Result.build(ResultCode.SUCCESS, "登录成功", userDTO);
        }
        return Result.build(ResultCode.FAIL, "账号或密码错误");
    }

    @ApiOperation("获取用户数据")
    @GetMapping("/getUserInfo")
    public Result<UserDTO> getUserInfo(@RequestParam("token") String token) {
        return Result.build(ResultCode.FAIL);
    }

}
