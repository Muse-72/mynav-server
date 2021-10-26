package com.pengfu.mynav.controller;

import com.pengfu.mynav.model.dto.UserDTO;
import com.pengfu.mynav.model.vo.UserVO;
import com.pengfu.mynav.service.UserService;
import com.pengfu.mynav.util.Result;
import com.pengfu.mynav.util.ResultCode;
import com.pengfu.mynav.util.ServiceException;
import com.pengfu.mynav.util.ValidatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result<UserVO> register(@RequestBody UserDTO userDTO) {
        // 参数判断
        if (ValidatorUtil.isExistEmpty(userDTO)) {
            return Result.build(ResultCode.PARAM_IS_LACK);
        }

        try {
            UserVO userVO = userService.register(userDTO);
            return Result.build(ResultCode.SUCCESS, "注册成功", userVO);
        } catch (ServiceException e) {
            return Result.build(ResultCode.FAIL, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(ResultCode.ERROR);
        }
    }

    @ApiOperation("用户登录")
    @PostMapping("login")
    public Result<UserVO> login(@RequestBody UserDTO userDTO) {
        // 参数判断
        if (ValidatorUtil.isExistEmpty(userDTO)) {
            return Result.build(ResultCode.PARAM_IS_LACK);
        }

        // 用户登录
        UserVO userVO = userService.login(userDTO.getUsername(), userDTO.getPassword());
        if (userVO != null) {
            return Result.build(ResultCode.SUCCESS, "登录成功", userVO);
        }
        return Result.build(ResultCode.FAIL, "账号或密码错误");
    }

    @ApiOperation("获取用户数据")
    @GetMapping("/getUserInfo")
    public Result<UserVO> getUserInfo(@RequestParam("token") String token) {
        return Result.build(ResultCode.FAIL);
    }

}
