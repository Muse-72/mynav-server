package com.pengfu.mynav.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author PrideZH
 * @date 2021/10/22 - 23:23
 */
@ApiModel("用户账号信息")
public class UserDTO {

    @ApiModelProperty(value = "用户账号", required = true)
    private String username;

    @ApiModelProperty(value = "用户MD5加密密码", required = true)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
